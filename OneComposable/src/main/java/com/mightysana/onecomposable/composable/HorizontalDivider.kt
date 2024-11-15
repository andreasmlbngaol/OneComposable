package com.mightysana.onecomposable.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.mightysana.onecomposable.OneColor

@Composable
fun OneTextHorizontalDivider(
    modifier: Modifier = Modifier,
    text: String,
    thickness: Dp = 1.dp,
    lineColor: Color = contentColorFor(OneColor.surface),
    style: TextStyle = MaterialTheme.typography.bodyMedium
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        HorizontalDivider(
            color = lineColor,
            thickness = thickness,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = text,
            style = style,
            textAlign = TextAlign.Center
        )
        HorizontalDivider(
            color = lineColor,
            thickness = thickness,
            modifier = Modifier.weight(1f)
        )

    }
}

@Composable
fun SurfaceVariantTextHorizontalDivider(
    modifier: Modifier = Modifier,
    text: String,
    thickness: Dp = 1.dp,
    lineColor: Color = contentColorFor(OneColor.surfaceVariant),
    style: TextStyle = MaterialTheme.typography.bodyMedium
) {
    OneTextHorizontalDivider(
        modifier = modifier,
        text = text,
        thickness = thickness,
        lineColor = lineColor,
        style = style
    )
}


@Composable
fun PrimaryTextHorizontalDivider(
    modifier: Modifier = Modifier,
    text: String,
    thickness: Dp = 1.dp,
    lineColor: Color = contentColorFor(OneColor.primary),
    style: TextStyle = MaterialTheme.typography.bodyMedium
) {
    OneTextHorizontalDivider(
        modifier = modifier,
        text = text,
        thickness = thickness,
        lineColor = lineColor,
        style = style
    )
}

@Composable
fun PrimaryContainerTextHorizontalDivider(
    modifier: Modifier = Modifier,
    text: String,
    thickness: Dp = 1.dp,
    lineColor: Color = contentColorFor(OneColor.primaryContainer),
    style: TextStyle = MaterialTheme.typography.bodyMedium
) {
    OneTextHorizontalDivider(
        modifier = modifier,
        text = text,
        thickness = thickness,
        lineColor = lineColor,
        style = style
    )
}

@Composable
fun SecondaryTextHorizontalDivider(
    modifier: Modifier = Modifier,
    text: String,
    thickness: Dp = 1.dp,
    lineColor: Color = contentColorFor(OneColor.secondary),
    style: TextStyle = MaterialTheme.typography.bodyMedium
) {
    OneTextHorizontalDivider(
        modifier = modifier,
        text = text,
        thickness = thickness,
        lineColor = lineColor,
        style = style
    )
}

@Composable
fun secondaryContainerTextHorizontalDivider(
    modifier: Modifier = Modifier,
    text: String,
    thickness: Dp = 1.dp,
    lineColor: Color = contentColorFor(OneColor.secondaryContainer),
    style: TextStyle = MaterialTheme.typography.bodyMedium
) {
    OneTextHorizontalDivider(
        modifier = modifier,
        text = text,
        thickness = thickness,
        lineColor = lineColor,
        style = style
    )
}

@Composable
fun tertiaryTextHorizontalDivider(
    modifier: Modifier = Modifier,
    text: String,
    thickness: Dp = 1.dp,
    lineColor: Color = contentColorFor(OneColor.tertiary),
    style: TextStyle = MaterialTheme.typography.bodyMedium
) {
    OneTextHorizontalDivider(
        modifier = modifier,
        text = text,
        thickness = thickness,
        lineColor = lineColor,
        style = style
    )
}

@Composable
fun tertiaryContainerTextHorizontalDivider(
    modifier: Modifier = Modifier,
    text: String,
    thickness: Dp = 1.dp,
    lineColor: Color = contentColorFor(OneColor.tertiaryContainer),
    style: TextStyle = MaterialTheme.typography.bodyMedium
) {
    OneTextHorizontalDivider(
        modifier = modifier,
        text = text,
        thickness = thickness,
        lineColor = lineColor,
        style = style
    )
}
