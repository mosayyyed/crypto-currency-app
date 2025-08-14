package com.example.cryptocurrencyapp.presentation.utils

import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp

@Composable
fun HtmlText(
    html: String,
    color: Color = MaterialTheme.colorScheme.onSurface
) {
    val annotatedString = buildAnnotatedString {
        val cleanText = html
            .replace("<p>", "")
            .replace("</p>", "\n\n")
            .replace("<br>", "\n")
            .replace("<br/>", "\n")
            .replace("<br />", "\n")
            .replace("<strong>", "")
            .replace("</strong>", "")
            .replace("<b>", "")
            .replace("</b>", "")
            .replace("<em>", "")
            .replace("</em>", "")
            .replace("<i>", "")
            .replace("</i>", "")
            .replace("<u>", "")
            .replace("</u>", "")
            .replace("&amp;", "&")
            .replace("&lt;", "<")
            .replace("&gt;", ">")
            .replace("&quot;", "\"")
            .replace("&#39;", "'")
            .replace("&nbsp;", " ")
            .trim()

        append(cleanText)

        // Apply color to entire text
        addStyle(
            style = SpanStyle(color = color),
            start = 0,
            end = cleanText.length
        )
    }

    ClickableText(
        text = annotatedString,
        style = LocalTextStyle.current.copy(
            lineHeight = 24.sp
        ),
        onClick = { }
    )
}

fun String.removeHtmlTags(): String {
    return this
        .replace("<p>", "")
        .replace("</p>", "\n\n")
        .replace("<br>", "\n")
        .replace("<br/>", "\n")
        .replace("<br />", "\n")
        .replace("<strong>", "")
        .replace("</strong>", "")
        .replace("<b>", "")
        .replace("</b>", "")
        .replace("<em>", "")
        .replace("</em>", "")
        .replace("<i>", "")
        .replace("</i>", "")
        .replace("<u>", "")
        .replace("</u>", "")
        .replace("&amp;", "&")
        .replace("&lt;", "<")
        .replace("&gt;", ">")
        .replace("&quot;", "\"")
        .replace("&#39;", "'")
        .replace("&nbsp;", " ")
        .replace(Regex("<[^>]*>"), "") // Remove any remaining HTML tags
        .trim()
}
