package com.example.cryptocurrencyapp.presentation.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = Primary,
    onPrimary = TextOnPrimary,
    primaryContainer = PrimaryVariant,
    onPrimaryContainer = TextOnPrimary,
    secondary = Secondary,
    onSecondary = TextOnPrimary,
    secondaryContainer = SecondaryVariant,
    onSecondaryContainer = TextOnPrimary,
    tertiary = Accent1,
    onTertiary = TextOnPrimary,
    background = BackgroundDark,
    onBackground = TextOnDark,
    surface = SurfaceDark,
    onSurface = TextOnDark,
    surfaceVariant = CardBackgroundDark,
    onSurfaceVariant = TextOnDark,
    error = Error,
    onError = TextOnPrimary,
    outline = BorderDark,
    inverseOnSurface = TextPrimary,
    inverseSurface = SurfaceLight,
    inversePrimary = PrimaryVariant,
    surfaceTint = Primary,
    outlineVariant = BorderDark,
    scrim = BackgroundDark
)

private val LightColorScheme = lightColorScheme(
    primary = Primary,
    onPrimary = TextOnPrimary,
    primaryContainer = androidx.compose.ui.graphics.Color(0xFFEEF2FF),
    onPrimaryContainer = PrimaryVariant,
    secondary = Secondary,
    onSecondary = TextOnPrimary,
    secondaryContainer = androidx.compose.ui.graphics.Color(0xFFD1FAE5),
    onSecondaryContainer = SecondaryVariant,
    tertiary = Accent1,
    onTertiary = TextOnPrimary,
    background = BackgroundLight,
    onBackground = TextPrimary,
    surface = SurfaceLight,
    onSurface = TextPrimary,
    surfaceVariant = CardBackground,
    onSurfaceVariant = TextPrimary,
    error = Error,
    onError = TextOnPrimary,
    outline = BorderLight,
    inverseOnSurface = TextOnDark,
    inverseSurface = SurfaceDark,
    inversePrimary = Primary,
    surfaceTint = Primary,
    outlineVariant = BorderLight,
    scrim = BackgroundLight
)

@Composable
fun CryptoCurrencyAppTheme(
    themeManager: ThemeManager? = null,
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    // Use ThemeManager if provided, otherwise fall back to system theme
    val isDarkTheme = if (themeManager != null) {
        val isDark by themeManager.isDarkTheme.collectAsState()
        isDark
    } else {
        darkTheme
    }

    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (isDarkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        isDarkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !isDarkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
