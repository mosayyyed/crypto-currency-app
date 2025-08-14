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
    // Modern Flat Color Combinations for Tags
    val colorCombinations = listOf(
        Primary to Primary.copy(alpha = 0.12f),
        Secondary to Secondary.copy(alpha = 0.12f),
        Accent1 to Accent1.copy(alpha = 0.12f),
        Accent2 to Accent2.copy(alpha = 0.12f),
        Accent3 to Accent3.copy(alpha = 0.12f),
        Accent4 to Accent4.copy(alpha = 0.12f),
        Accent5 to Accent5.copy(alpha = 0.12f),
        Info to Info.copy(alpha = 0.12f)
    )

    // Select color based on tag content for consistency
    val colorIndex = tag.hashCode().rem(colorCombinations.size).let {
        if (it < 0) it + colorCombinations.size else it
    }
    val (textColor, backgroundColor) = colorCombinations[colorIndex]

    // Pure Flat Tag Design - No Shadows or Gradients
    Box(
        modifier = Modifier
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(8.dp)
            )
            .border(
                width = 1.dp,
                color = textColor.copy(alpha = 0.3f),
                shape = RoundedCornerShape(8.dp)
            )
            .padding(horizontal = 12.dp, vertical = 6.dp)
    ) {
        Text(
            text = tag,
            style = MaterialTheme.typography.bodySmall,
            fontWeight = FontWeight.Medium,
            color = textColor
        )
    }
}
