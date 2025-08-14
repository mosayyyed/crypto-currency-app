package com.example.cryptocurrencyapp.presentation.utils

import android.text.Html
import android.text.Spanned
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString

/**
 * Remove HTML tags from text and return clean string
 */
fun removeHtmlTags(htmlText: String?): String {
    return if (htmlText.isNullOrEmpty()) {
        ""
    } else {
        Html.fromHtml(htmlText, Html.FROM_HTML_MODE_LEGACY).toString().trim()
    }
}

/**
 * Convert HTML text to AnnotatedString for better formatting in Compose
 */
fun htmlToAnnotatedString(htmlText: String?): AnnotatedString {
    if (htmlText.isNullOrEmpty()) return AnnotatedString("")

    val spanned: Spanned = Html.fromHtml(htmlText, Html.FROM_HTML_MODE_LEGACY)
    return buildAnnotatedString {
        append(spanned.toString())

        // You can add custom styling here based on HTML tags if needed
        // For now, we'll keep it simple and clean
    }
}

@Composable
fun HtmlText(
    html: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onSurface
) {
    val cleanText = removeHtmlTags(html)

    SelectionContainer {
        Text(
            text = cleanText,
            modifier = modifier,
            color = color,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}
