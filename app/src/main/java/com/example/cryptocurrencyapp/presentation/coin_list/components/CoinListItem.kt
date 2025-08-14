package com.example.cryptocurrencyapp.presentation.coin_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cryptocurrencyapp.domain.model.Coin
import com.example.cryptocurrencyapp.presentation.ui.theme.*

@Composable
fun CoinListItem(
    coin: Coin,
    onItemClick: (Coin) -> Unit
) {
    // Pure Flat Card Design - No Shadows
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
            .clickable { onItemClick(coin) }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f)
            ) {
                // Coin Avatar - Pure Flat Design
                Box(
                    modifier = Modifier
                        .size(52.dp)
                        .background(
                            color = Primary.copy(alpha = 0.1f),
                            shape = RoundedCornerShape(16.dp)
                        )
                        .border(
                            width = 1.dp,
                            color = Primary.copy(alpha = 0.2f),
                            shape = RoundedCornerShape(16.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = coin.symbol.take(3).uppercase(),
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.Bold,
                        color = Primary,
                        fontSize = 14.sp
                    )
                }

                Spacer(modifier = Modifier.width(16.dp))

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = coin.name,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.SemiBold,
                        color = TextPrimary,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = coin.symbol.uppercase(),
                            style = MaterialTheme.typography.bodyMedium,
                            color = TextSecondary,
                            fontWeight = FontWeight.Medium
                        )

                        Spacer(modifier = Modifier.width(12.dp))

                        // Rank Badge - Flat Design
                        Box(
                            modifier = Modifier
                                .background(
                                    color = when {
                                        coin.rank <= 10 -> Success.copy(alpha = 0.15f)
                                        coin.rank <= 50 -> Warning.copy(alpha = 0.15f)
                                        else -> TextSecondary.copy(alpha = 0.15f)
                                    },
                                    shape = RoundedCornerShape(8.dp)
                                )
                                .border(
                                    width = 1.dp,
                                    color = when {
                                        coin.rank <= 10 -> Success.copy(alpha = 0.3f)
                                        coin.rank <= 50 -> Warning.copy(alpha = 0.3f)
                                        else -> TextSecondary.copy(alpha = 0.3f)
                                    },
                                    shape = RoundedCornerShape(8.dp)
                                )
                        ) {
                            Text(
                                text = "#${coin.rank}",
                                style = MaterialTheme.typography.labelSmall,
                                color = when {
                                    coin.rank <= 10 -> Success
                                    coin.rank <= 50 -> Warning
                                    else -> TextSecondary
                                },
                                fontWeight = FontWeight.SemiBold,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                            )
                        }
                    }
                }
            }

            Column(
                horizontalAlignment = Alignment.End
            ) {
                // Activity Status - Flat Design
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
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(8.dp)
                                .background(
                                    color = if (coin.isActive) Success else Error,
                                    shape = CircleShape
                                )
                        )

                        Spacer(modifier = Modifier.width(6.dp))

                        Text(
                            text = if (coin.isActive) "Active" else "Inactive",
                            style = MaterialTheme.typography.labelSmall,
                            color = if (coin.isActive) Success else Error,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
        }
    }
}
