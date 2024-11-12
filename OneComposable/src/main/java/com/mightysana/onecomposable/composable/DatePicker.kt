package com.mightysana.onecomposable.composable

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntSize
import com.mightysana.onecomposable.OneIcons

@Composable
fun OneDatePickerField(
    value: String,
    label: @Composable (() -> Unit)?,
    modifier: Modifier = Modifier,
    supportingText: @Composable (() -> Unit)? = null,
    onExpand: () -> Unit,
    isError: Boolean = false
) {
    var boxSize by remember { mutableStateOf(IntSize(0, 0)) }
    var textFieldSize by remember { mutableStateOf(IntSize(0, 0)) }
    val focusRequester: FocusRequester = remember { FocusRequester() }

    Box(
        modifier = modifier
            .onGloballyPositioned { coordinates ->
                boxSize = coordinates.size
            }
    ) {
        OneTextField(
            isError = isError,
            value = value,
            onValueChange = { },
            readOnly = true,
            label = label,
            supportingText = supportingText,
            singleLine = true,
            trailingIcon = {
                IconButton(onClick = onExpand) {
                    OneIcon(OneIcons.DatePicker)
                }
            },
            modifier = modifier
                .onGloballyPositioned { coordinates ->
                    textFieldSize = coordinates.size
                }
                .focusRequester(focusRequester)
        )

        Box(
            modifier = Modifier
                .width(with(LocalDensity.current) { textFieldSize.width.toDp() })
                .height(with(LocalDensity.current) { textFieldSize.height.toDp() })
                .clip(MaterialTheme.shapes.large)
                .pointerInput(Unit) {
                    detectTapGestures(
                        onTap = {
                            onExpand()
                            focusRequester.requestFocus()
                        }
                    )
                }
                .background(Color.Transparent)
        )
    }
}

@Composable
fun OneOutlinedButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = ButtonDefaults.outlinedShape,
    colors: ButtonColors = ButtonDefaults.outlinedButtonColors(),
    elevation: ButtonElevation? = null,
    border: BorderStroke? = ButtonDefaults.outlinedButtonBorder(enabled),
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    interactionSource: MutableInteractionSource? = null,
    content: @Composable() (RowScope.() -> Unit)
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = shape,
        colors = colors,
        elevation = elevation,
        border = border,
        contentPadding = contentPadding,
        interactionSource = interactionSource,
        content = content
    )
}
