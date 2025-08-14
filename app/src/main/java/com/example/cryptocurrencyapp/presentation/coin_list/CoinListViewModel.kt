package com.example.cryptocurrencyapp.presentation.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptocurrencyapp.common.Resource
import com.example.cryptocurrencyapp.domain.use_case.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
) : ViewModel() {

    private val _state = mutableStateOf(CoinListState())
    val state: State<CoinListState> = _state

    private val _isNetworkError = mutableStateOf(false)
    val isNetworkError: State<Boolean> = _isNetworkError

    init {
        getCoins()
    }

    fun getCoins() {
        getCoinsUseCase().onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = CoinListState(coins = result.data ?: emptyList())
                    _isNetworkError.value = false
                }
                is Resource.Error -> {
                    // فحص إذا كان الخطأ بسبب الشبكة
                    val isNetworkIssue = result.message?.let { message ->
                        message.contains("network", ignoreCase = true) ||
                        message.contains("internet", ignoreCase = true) ||
                        message.contains("connection", ignoreCase = true) ||
                        message.contains("timeout", ignoreCase = true) ||
                        message.contains("unable to resolve host", ignoreCase = true) ||
                        message.contains("socket", ignoreCase = true) ||
                        message.contains("unreachable", ignoreCase = true)
                    } ?: false

                    if (isNetworkIssue) {
                        _isNetworkError.value = true
                        _state.value = CoinListState(
                            error = "لا يوجد اتصال بالإنترنت"
                        )
                    } else {
                        _isNetworkError.value = false
                        _state.value = CoinListState(
                            error = result.message ?: "حدث خطأ غير متوقع"
                        )
                    }
                }
                is Resource.Loading -> {
                    _state.value = CoinListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun retryConnection() {
        _isNetworkError.value = false
        _state.value = CoinListState(isLoading = true)
        viewModelScope.launch {
            delay(1000) // تأخير قصير قبل إعادة المحاولة
            getCoins()
        }
    }
}
