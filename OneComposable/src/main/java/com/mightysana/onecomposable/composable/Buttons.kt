package com.mightysana.onecomposable.composable

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.mightysana.onecomposable.OneColor
import com.mightysana.onecomposable.OneShape
import com.mightysana.onecomposable.OneValue
import com.mightysana.onecomposable.Preview
import com.mightysana.onecomposable.R

object OneButtonDefaults {
    val shape: Shape
        @Composable
        get() = OneShape.large
}

@Composable
fun OneButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = OneButtonDefaults.shape,
    containerColor: Color = OneColor.primary,
    contentColor: Color = contentColorFor(containerColor),
    elevation: ButtonElevation? = ButtonDefaults.buttonElevation(),
    border: BorderStroke? = null,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    interactionSource: MutableInteractionSource? = null,
    content: @Composable() (RowScope.() -> Unit)
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = shape,
        colors = ButtonDefaults.buttonColors().copy(
            containerColor = containerColor,
            contentColor = contentColor,
            disabledContainerColor = containerColor.copy(alpha = OneValue.ALPHA),
            disabledContentColor = contentColor.copy(alpha = OneValue.ALPHA)
        ),
        elevation = elevation,
        border = border,
        contentPadding = contentPadding,
        interactionSource = interactionSource,
        content = content
    )
}

@Composable
fun SecondaryButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = OneButtonDefaults.shape,
    elevation: ButtonElevation? = ButtonDefaults.buttonElevation(),
    border: BorderStroke? = null,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    interactionSource: MutableInteractionSource? = null,
    content: @Composable() (RowScope.() -> Unit)
) {
    OneButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = shape,
        containerColor = OneColor.secondary,
        elevation = elevation,
        border = border,
        contentPadding = contentPadding,
        interactionSource = interactionSource,
        content = content
    )
}

@Composable
fun TertiaryButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = OneButtonDefaults.shape,
    elevation: ButtonElevation? = ButtonDefaults.buttonElevation(),
    border: BorderStroke? = null,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    interactionSource: MutableInteractionSource? = null,
    content: @Composable() (RowScope.() -> Unit)
) {
    OneButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = shape,
        containerColor = OneColor.tertiary,
        elevation = elevation,
        border = border,
        contentPadding = contentPadding,
        interactionSource = interactionSource,
        content = content
    )
}

@Composable
fun OneOutlinedButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = OneButtonDefaults.shape,
    color: Color = OneColor.primary,
    elevation: ButtonElevation? = null,
    border: BorderStroke = BorderStroke(
        width = 1.dp,
        color = if(enabled) color else color.copy(alpha = 0.12f)
    ),
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    interactionSource: MutableInteractionSource? = null,
    content: @Composable() (RowScope.() -> Unit)
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = shape,
        colors = ButtonDefaults.outlinedButtonColors().copy(
            contentColor = color,
            disabledContentColor = color.copy(alpha = OneValue.ALPHA)
        ),
        elevation = elevation,
        border = border,
        contentPadding = contentPadding,
        interactionSource = interactionSource,
        content = content
    )
}

@Composable
fun SecondaryOutlinedButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = OneButtonDefaults.shape,
    elevation: ButtonElevation? = null,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    interactionSource: MutableInteractionSource? = null,
    content: @Composable() (RowScope.() -> Unit)
) {
    OneOutlinedButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = shape,
        color = OneColor.secondary,
        elevation = elevation,
        contentPadding = contentPadding,
        interactionSource = interactionSource,
        content = content
    )
}

@Composable
fun TertiaryOutlinedButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = OneButtonDefaults.shape,
    elevation: ButtonElevation? = null,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    interactionSource: MutableInteractionSource? = null,
    content: @Composable() (RowScope.() -> Unit)
) {
    OneOutlinedButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = shape,
        color = OneColor.tertiary,
        elevation = elevation,
        contentPadding = contentPadding,
        interactionSource = interactionSource,
        content = content
    )
}

@Composable
fun OneTextButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = ButtonDefaults.textShape,
    color: Color = OneColor.primary,
    elevation: ButtonElevation? = null,
    border: BorderStroke? = null,
    contentPadding: PaddingValues = ButtonDefaults.TextButtonContentPadding,
    interactionSource: MutableInteractionSource? = null,
    content: @Composable (RowScope.() -> Unit)
) {
    TextButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = shape,
        colors = ButtonDefaults.textButtonColors().copy(
            contentColor = color,
            disabledContentColor = color.copy(alpha = 0.38f)
        ),
        elevation = elevation,
        border = border,
        contentPadding = contentPadding,
        interactionSource = interactionSource,
        content = content
    )
}

@Composable
fun SecondaryTextButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = ButtonDefaults.textShape,
    elevation: ButtonElevation? = null,
    border: BorderStroke? = null,
    contentPadding: PaddingValues = ButtonDefaults.TextButtonContentPadding,
    interactionSource: MutableInteractionSource? = null,
    content: @Composable (RowScope.() -> Unit)
) {
    OneTextButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = shape,
        color = OneColor.secondary,
        elevation = elevation,
        border = border,
        contentPadding = contentPadding,
        interactionSource = interactionSource,
        content = content
    )
}

@Composable
fun TertiaryTextButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = ButtonDefaults.textShape,
    elevation: ButtonElevation? = null,
    border: BorderStroke? = null,
    contentPadding: PaddingValues = ButtonDefaults.TextButtonContentPadding,
    interactionSource: MutableInteractionSource? = null,
    content: @Composable (RowScope.() -> Unit)
) {
    OneTextButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = shape,
        color = OneColor.tertiary,
        elevation = elevation,
        border = border,
        contentPadding = contentPadding,
        interactionSource = interactionSource,
        content = content
    )
}

@Composable
fun OneImageButton(
    onClick: () -> Unit,
    painter: Painter,
    modifier: Modifier = Modifier,
    width: Dp = 40.dp,
    height: Dp = 40.dp
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
            .width(width)
            .height(height)
    ) {
        OneImage(
            painter = painter,
        )
    }
}


@PreviewLightDark
@Composable
fun ButtonPreview() {
    Preview {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            OneButton({}) { Text("OneButton") }
            SecondaryButton({}) { Text("SecondaryButton") }
            TertiaryButton({}) { Text("TertiaryButton") }
            OneOutlinedButton({}) { Text("OneOutlinedButton") }
            SecondaryOutlinedButton({}) { Text("SecondaryOutlinedButton") }
            TertiaryOutlinedButton({}) { Text("TertiaryOutlinedButton") }
            OneTextButton({}) { Text("OneTextButton") }
            SecondaryTextButton({}) { Text("SecondaryTextButton") }
            TertiaryTextButton({}) { Text("TertiaryTextButton") }
            OneImageButton({}, painterResource(R.drawable.ic_launcher_foreground))
        }
    }
}