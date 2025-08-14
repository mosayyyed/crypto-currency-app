package com.example.cryptocurrencyapp.presentation.coin_details

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.cryptocurrencyapp.presentation.coin_details.components.CoinTag
import com.example.cryptocurrencyapp.presentation.coin_details.components.TeamListItem
import com.example.cryptocurrencyapp.presentation.components.HtmlText
import com.example.cryptocurrencyapp.presentation.ui.theme.*
import com.example.cryptocurrencyapp.presentation.utils.removeHtmlTags

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoinDetailScreen(
    navController: NavController,
    viewModel: CoinDetailsViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundLight)
    ) {
        // Modern Flat Header with Back Button
        TopAppBar(
            title = {
                Text(
                    text = "Coin Details",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.SemiBold
                )
            },
            navigationIcon = {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = SurfaceLight,
                titleContentColor = TextPrimary
            )
        )

        Box(modifier = Modifier.fillMaxSize()) {
            state.coin?.let { coin ->
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(20.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    item {
                        // Coin Header Card - Pure Flat Design
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(
                                    color = SurfaceLight,
                                    shape = RoundedCornerShape(20.dp)
                                )
                                .border(
                                    width = 1.dp,
                                    color = BorderLight,
                                    shape = RoundedCornerShape(20.dp)
                                )
                        ) {
                            // Accent Header Background
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(
                                        color = Primary.copy(alpha = 0.05f),
                                        shape = RoundedCornerShape(20.dp)
                                    )
                                    .padding(24.dp)
                            ) {
                                Column {
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalAlignment = Alignment.Top
                                    ) {
                                        Column(modifier = Modifier.weight(1f)) {
                                            Text(
                                                text = "${coin.rank}. ${coin.name}",
                                                style = MaterialTheme.typography.headlineSmall,
                                                fontWeight = FontWeight.Bold,
                                                color = TextPrimary
                                            )

                                            Spacer(modifier = Modifier.height(4.dp))

                                            Text(
                                                text = coin.symbol.uppercase(),
                                                style = MaterialTheme.typography.titleMedium,
                                                fontWeight = FontWeight.Medium,
                                                color = Primary
                                            )

                                            Spacer(modifier = Modifier.height(12.dp))

                                            // Status Badge - Pure Flat
                                            Box(
                                                modifier = Modifier
                                                    .background(
                                                        color = if (coin.isActive) Success.copy(alpha = 0.15f) else Error.copy(alpha = 0.15f),
                                                        shape = RoundedCornerShape(12.dp)
                                                    )
                                                    .border(
                                                        width = 1.dp,
                                                        color = if (coin.isActive) Success.copy(alpha = 0.3f) else Error.copy(alpha = 0.3f),
                                                        shape = RoundedCornerShape(12.dp)
                                                    )
                                            ) {
                                                Row(
                                                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                                                    verticalAlignment = Alignment.CenterVertically
                                                ) {
                                                    Text(
                                                        text = if (coin.isActive) "✅" else "❌",
                                                        fontSize = 16.sp
                                                    )
                                                    Spacer(modifier = Modifier.width(6.dp))
                                                    Text(
                                                        text = if (coin.isActive) "Active" else "Inactive",
                                                        style = MaterialTheme.typography.labelLarge,
                                                        color = if (coin.isActive) Success else Error,
                                                        fontWeight = FontWeight.SemiBold
                                                    )
                                                }
                                            }
                                        }

                                        IconButton(
                                            onClick = { /* Add to favorites */ }
                                        ) {
                                            Icon(
                                                imageVector = Icons.Default.Star,
                                                contentDescription = "Add to favorites",
                                                tint = Warning,
                                                modifier = Modifier.size(28.dp)
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }

                    item {
                        // Description Card - Flat Design with HTML Support
                        if (coin.description.isNotEmpty()) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(
                                        color = SurfaceLight,
                                        shape = RoundedCornerShape(16.dp)
                                    )
                                    .border(
                                        width = 1.dp,
                                        color = BorderLight,
                                        shape = RoundedCornerShape(16.dp)
                                    )
                            ) {
                                Column(
                                    modifier = Modifier.padding(20.dp)
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Text(
                                            text = "📖",
                                            fontSize = 20.sp
                                        )
                                        Spacer(modifier = Modifier.width(8.dp))
                                        Text(
                                            text = "Description",
                                            style = MaterialTheme.typography.titleMedium,
                                            fontWeight = FontWeight.SemiBold,
                                            color = TextPrimary
                                        )
                                    }

                                    Spacer(modifier = Modifier.height(12.dp))

                                    // استخدام مكتبة Rich Text لمعالجة HTML
                                    HtmlText(
                                        htmlContent = coin.description,
                                        textColor = TextSecondary
                                    )
                                }
                            }
                        }
                    }

                    item {
                        // Tags Section - Pure Flat
                        if (coin.tags.isNotEmpty()) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(
                                        color = SurfaceLight,
                                        shape = RoundedCornerShape(16.dp)
                                    )
                                    .border(
                                        width = 1.dp,
                                        color = BorderLight,
                                        shape = RoundedCornerShape(16.dp)
                                    )
                            ) {
                                Column(
                                    modifier = Modifier.padding(20.dp)
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Text(
                                            text = "🏷️",
                                            fontSize = 20.sp
                                        )
                                        Spacer(modifier = Modifier.width(8.dp))
                                        Text(
                                            text = "Tags",
                                            style = MaterialTheme.typography.titleMedium,
                                            fontWeight = FontWeight.SemiBold,
                                            color = TextPrimary
                                        )
                                    }

                                    Spacer(modifier = Modifier.height(16.dp))

                                    // Tags Grid
                                    coin.tags.chunked(3).forEach { rowTags ->
                                        Row(
                                            modifier = Modifier.fillMaxWidth(),
                                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                                        ) {
                                            rowTags.forEach { tag ->
                                                CoinTag(tag = tag)
                                            }
                                        }
                                        Spacer(modifier = Modifier.height(8.dp))
                                    }
                                }
                            }
                        }
                    }

                    item {
                        // Team Section - Flat Design
                        if (coin.team.isNotEmpty()) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(
                                        color = SurfaceLight,
                                        shape = RoundedCornerShape(16.dp)
                                    )
                                    .border(
                                        width = 1.dp,
                                        color = BorderLight,
                                        shape = RoundedCornerShape(16.dp)
                                    )
                            ) {
                                Column(
                                    modifier = Modifier.padding(20.dp)
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Text(
                                            text = "👥",
                                            fontSize = 20.sp
                                        )
                                        Spacer(modifier = Modifier.width(8.dp))
                                        Text(
                                            text = "Team Members",
                                            style = MaterialTheme.typography.titleMedium,
                                            fontWeight = FontWeight.SemiBold,
                                            color = TextPrimary
                                        )
                                    }

                                    Spacer(modifier = Modifier.height(16.dp))

                                    coin.team.forEach { teamMember ->
                                        TeamListItem(
                                            teamMember = com.example.cryptocurrencyapp.domain.model.TeamMember(
                                                id = teamMember.id,
                                                name = teamMember.name,
                                                position = teamMember.position
                                            ),
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(vertical = 4.dp)
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }

            if (state.error.isNotBlank()) {
                // Error State - Pure Flat
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                        .align(Alignment.Center)
                        .background(
                            color = Error.copy(alpha = 0.1f),
                            shape = RoundedCornerShape(16.dp)
                        )
                        .border(
                            width = 1.dp,
                            color = Error.copy(alpha = 0.3f),
                            shape = RoundedCornerShape(16.dp)
                        )
                ) {
                    Column(
                        modifier = Modifier.padding(24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "❌",
                            fontSize = 48.sp
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = "Error occurred",
                            style = MaterialTheme.typography.titleMedium,
                            color = Error,
                            fontWeight = FontWeight.SemiBold
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = state.error,
                            style = MaterialTheme.typography.bodyMedium,
                            color = TextSecondary,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }

            if (state.isLoading) {
                // Loading State - Flat
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        CircularProgressIndicator(
                            color = Primary,
                            strokeWidth = 3.dp,
                            modifier = Modifier.size(48.dp)
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "Loading coin details...",
                            style = MaterialTheme.typography.bodyLarge,
                            color = TextSecondary
                        )
                    }
                }
            }
        }
    }
}
