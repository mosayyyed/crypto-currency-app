package com.example.cryptocurrencyapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.cryptocurrencyapp.presentation.ui.theme.ThemeManager
import compose.icons.FeatherIcons
import compose.icons.feathericons.Moon
import compose.icons.feathericons.Sun

@Composable
fun ThemeToggleButton(
    themeManager: ThemeManager,
    modifier: Modifier = Modifier
) {
    val isDarkTheme by themeManager.isDarkTheme.collectAsState()

    Card(
        modifier = modifier
            .size(48.dp)
            .clip(CircleShape)
            .clickable { themeManager.toggleTheme() },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        elevation = CardDefaults.cardElevation(0.dp) // Flat design - no elevation
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = if (isDarkTheme) FeatherIcons.Sun else FeatherIcons.Moon,
                contentDescription = if (isDarkTheme) "Switch to Light Theme" else "Switch to Dark Theme",
                tint = MaterialTheme.colorScheme.onPrimaryContainer,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Composable
fun ThemeToggleSwitch(
    themeManager: ThemeManager,
    modifier: Modifier = Modifier
) {
    val isDarkTheme by themeManager.isDarkTheme.collectAsState()

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Icon(
            imageVector = FeatherIcons.Sun,
            contentDescription = "Light Theme",
            tint = if (!isDarkTheme) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.size(20.dp)
        )

        Switch(
            checked = isDarkTheme,
            onCheckedChange = { themeManager.setDarkTheme(it) },
            colors = SwitchDefaults.colors(
                checkedThumbColor = MaterialTheme.colorScheme.primary,
                uncheckedThumbColor = MaterialTheme.colorScheme.outline,
                checkedTrackColor = MaterialTheme.colorScheme.primaryContainer,
                uncheckedTrackColor = MaterialTheme.colorScheme.surfaceVariant
            )
        )

        Icon(
            imageVector = FeatherIcons.Moon,
            contentDescription = "Dark Theme",
            tint = if (isDarkTheme) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.size(20.dp)
        )
    }
}
