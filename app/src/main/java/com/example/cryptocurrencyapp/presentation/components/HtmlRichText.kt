package com.example.cryptocurrencyapp.presentation.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun HtmlText(
    htmlContent: String,
    modifier: Modifier = Modifier,
    textColor: Color = MaterialTheme.colorScheme.onSurface
) {
    val cleanText = htmlContent
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
        .replace("<h1>", "\n")
        .replace("</h1>", "\n")
        .replace("<h2>", "\n")
        .replace("</h2>", "\n")
        .replace("<h3>", "\n")
        .replace("</h3>", "\n")
        .replace("<li>", "• ")
        .replace("</li>", "\n")
        .replace("<ul>", "")
        .replace("</ul>", "\n")
        .replace("<ol>", "")
        .replace("</ol>", "\n")
        .replace("&amp;", "&")
        .replace("&lt;", "<")
        .replace("&gt;", ">")
        .replace("&quot;", "\"")
        .replace("&#39;", "'")
        .replace("&nbsp;", " ")
        .replace("&copy;", "©")
        .replace("&reg;", "®")
        .replace("&trade;", "™")
        .replace(Regex("<[^>]*>"), "")
        .replace(Regex("\\s+"), " ")
        .replace("\n ", "\n")
        .trim()

    Text(
        text = cleanText,
        modifier = modifier,
        style = MaterialTheme.typography.bodyMedium.copy(
            color = textColor,
            lineHeight = 24.sp,
            textAlign = TextAlign.Start
        )
    )
}
