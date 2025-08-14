package com.example.cryptocurrencyapp.presentation.coin_details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.cryptocurrencyapp.presentation.ui.theme.*
import kotlin.random.Random

@Composable
fun CoinTag(
    tag: String
) {
    val colors = listOf(
        Primary to Primary.copy(alpha = 0.15f),
        Secondary to Secondary.copy(alpha = 0.15f),
        Accent1 to Accent1.copy(alpha = 0.15f),
        Accent2 to Accent2.copy(alpha = 0.15f),
        Accent3 to Accent3.copy(alpha = 0.15f),
        Accent4 to Accent4.copy(alpha = 0.15f),
        Accent5 to Accent5.copy(alpha = 0.15f),
        Warning to Warning.copy(alpha = 0.15f),
        Info to Info.copy(alpha = 0.15f)
    )

    val randomColor = colors.random()

    Box(
        modifier = Modifier
            .background(
                color = randomColor.second,
                shape = RoundedCornerShape(12.dp)
            )
            .border(
                width = 1.dp,
                color = randomColor.first.copy(alpha = 0.3f),
                shape = RoundedCornerShape(12.dp)
            )
            .padding(horizontal = 12.dp, vertical = 8.dp)
    ) {
        Text(
            text = tag,
            style = MaterialTheme.typography.labelMedium,
            color = randomColor.first,
            fontWeight = FontWeight.SemiBold
        )
    }
}
