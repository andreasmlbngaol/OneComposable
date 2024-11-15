package com.mightysana.onecomposable.composable.scaffold

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.FloatingActionButtonElevation
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.mightysana.onecomposable.OneColor
import com.mightysana.onecomposable.OneShape
import com.mightysana.onecomposable.OneValue
import com.mightysana.onecomposable.composable.OneIcon
import com.mightysana.onecomposable.composable.OneIcons
import com.mightysana.onecomposable.Preview

object OneFABDefaults {
    val shape: Shape
        @Composable
        get() = OneShape.large
}

@Composable
fun OneFAB(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = OneFABDefaults.shape,
    color: Color = OneColor.primary,
    elevation: FloatingActionButtonElevation = FloatingActionButtonDefaults.elevation(),
    interactionSource: MutableInteractionSource? = null,
    content: @Composable (() -> Unit)
) {
    FloatingActionButton(
        onClick = onClick,
        modifier = modifier,
        shape = shape,
        containerColor = color,
        contentColor = contentColorFor(color),
        elevation = elevation,
        interactionSource = interactionSource,
        content = content
    )
}

@Composable
fun PrimaryContainerFAB(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = OneFABDefaults.shape,
    elevation: FloatingActionButtonElevation = FloatingActionButtonDefaults.elevation(),
    interactionSource: MutableInteractionSource? = null,
    content: @Composable (() -> Unit)
) {
    OneFAB(
        onClick = onClick,
        modifier = modifier,
        shape = shape,
        color = OneColor.primaryContainer,
        elevation = elevation,
        interactionSource = interactionSource,
        content = content
    )
}

@Composable
fun SecondaryFAB(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = OneFABDefaults.shape,
    elevation: FloatingActionButtonElevation = FloatingActionButtonDefaults.elevation(),
    interactionSource: MutableInteractionSource? = null,
    content: @Composable (() -> Unit)
) {
    OneFAB(
        onClick = onClick,
        modifier = modifier,
        shape = shape,
        color = OneColor.secondary,
        elevation = elevation,
        interactionSource = interactionSource,
        content = content
    )
}

@Composable
fun SecondaryContainerFAB(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = OneFABDefaults.shape,
    elevation: FloatingActionButtonElevation = FloatingActionButtonDefaults.elevation(),
    interactionSource: MutableInteractionSource? = null,
    content: @Composable (() -> Unit)
) {
    OneFAB(
        onClick = onClick,
        modifier = modifier,
        shape = shape,
        color = OneColor.secondaryContainer,
        elevation = elevation,
        interactionSource = interactionSource,
        content = content
    )
}


@Composable
fun TertiaryFAB(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = OneFABDefaults.shape,
    elevation: FloatingActionButtonElevation = FloatingActionButtonDefaults.elevation(),
    interactionSource: MutableInteractionSource? = null,
    content: @Composable (() -> Unit)
) {
    OneFAB(
        onClick = onClick,
        modifier = modifier,
        shape = shape,
        color = OneColor.tertiary,
        elevation = elevation,
        interactionSource = interactionSource,
        content = content
    )
}

@Composable
fun TertiaryContainerFAB(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = OneFABDefaults.shape,
    elevation: FloatingActionButtonElevation = FloatingActionButtonDefaults.elevation(),
    interactionSource: MutableInteractionSource? = null,
    content: @Composable (() -> Unit)
) {
    OneFAB(
        onClick = onClick,
        modifier = modifier,
        shape = shape,
        color = OneColor.tertiaryContainer,
        elevation = elevation,
        interactionSource = interactionSource,
        content = content
    )
}

@Composable
fun OneExtendedFAB(
    text: @Composable (() -> Unit),
    icon: @Composable (() -> Unit),
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    expanded: Boolean = true,
    shape: Shape = OneFABDefaults.shape,
    color: Color = OneColor.primary,
    elevation: FloatingActionButtonElevation = FloatingActionButtonDefaults.elevation(),
    interactionSource: MutableInteractionSource? = null
) {
    ExtendedFloatingActionButton(
        text = text,
        icon = icon,
        onClick = onClick,
        modifier = modifier,
        expanded = expanded,
        shape = shape,
        containerColor = color,
        contentColor = contentColorFor(color),
        elevation = elevation,
        interactionSource = interactionSource
    )
}

@Composable
fun PrimaryContainerExtendedFAB(
    text: @Composable (() -> Unit),
    icon: @Composable (() -> Unit),
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    expanded: Boolean = true,
    shape: Shape = OneFABDefaults.shape,
    elevation: FloatingActionButtonElevation = FloatingActionButtonDefaults.elevation(),
    interactionSource: MutableInteractionSource? = null
) {
    OneExtendedFAB(
        text = text,
        icon = icon,
        onClick = onClick,
        modifier = modifier,
        expanded = expanded,
        shape = shape,
        color = OneColor.primaryContainer,
        elevation = elevation,
        interactionSource = interactionSource
    )
}

@Composable
fun SecondaryExtendedFAB(
    text: @Composable (() -> Unit),
    icon: @Composable (() -> Unit),
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    expanded: Boolean = true,
    shape: Shape = OneFABDefaults.shape,
    elevation: FloatingActionButtonElevation = FloatingActionButtonDefaults.elevation(),
    interactionSource: MutableInteractionSource? = null
) {
    OneExtendedFAB(
        text = text,
        icon = icon,
        onClick = onClick,
        modifier = modifier,
        expanded = expanded,
        shape = shape,
        color = OneColor.secondary,
        elevation = elevation,
        interactionSource = interactionSource
    )
}

@Composable
fun SecondaryContainerExtendedFAB(
    text: @Composable (() -> Unit),
    icon: @Composable (() -> Unit),
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    expanded: Boolean = true,
    shape: Shape = OneFABDefaults.shape,
    elevation: FloatingActionButtonElevation = FloatingActionButtonDefaults.elevation(),
    interactionSource: MutableInteractionSource? = null
) {
    OneExtendedFAB(
        text = text,
        icon = icon,
        onClick = onClick,
        modifier = modifier,
        expanded = expanded,
        shape = shape,
        color = OneColor.secondaryContainer,
        elevation = elevation,
        interactionSource = interactionSource
    )
}

@Composable
fun TertiaryExtendedFAB(
    text: @Composable (() -> Unit),
    icon: @Composable (() -> Unit),
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    expanded: Boolean = true,
    shape: Shape = OneFABDefaults.shape,
    elevation: FloatingActionButtonElevation = FloatingActionButtonDefaults.elevation(),
    interactionSource: MutableInteractionSource? = null
) {
    OneExtendedFAB(
        text = text,
        icon = icon,
        onClick = onClick,
        modifier = modifier,
        expanded = expanded,
        shape = shape,
        color = OneColor.tertiary,
        elevation = elevation,
        interactionSource = interactionSource
    )
}

@Composable
fun TertiaryContainerExtendedFAB(
    text: @Composable (() -> Unit),
    icon: @Composable (() -> Unit),
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    expanded: Boolean = true,
    shape: Shape = OneFABDefaults.shape,
    elevation: FloatingActionButtonElevation = FloatingActionButtonDefaults.elevation(),
    interactionSource: MutableInteractionSource? = null
) {
    OneExtendedFAB(
        text = text,
        icon = icon,
        onClick = onClick,
        modifier = modifier,
        expanded = expanded,
        shape = shape,
        color = OneColor.tertiaryContainer,
        elevation = elevation,
        interactionSource = interactionSource
    )
}

@Composable
fun ExpandableFAB(
    expanded: Boolean,
    parent: @Composable () -> Unit,
    children: @Composable () -> Unit
) {
    AnimatedContent(
        targetState = expanded,
        label = "ExpandableFAB"
    ) { expanded ->
        Column(
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.spacedBy(OneValue.smallPadding)
        ) {
            if (expanded) children()
            parent()
        }
    }
}







@PreviewLightDark
@Composable
fun FABPreview() {
    Preview {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(OneValue.padding)
        ) {
            OneFAB({}) { OneIcon(OneIcons.Plus) }
            OneExtendedFAB({ Text("OneExtendedFAB") }, { OneIcon(OneIcons.Plus) }, {})
            PrimaryContainerFAB({}) { OneIcon(OneIcons.Plus) }
            PrimaryContainerExtendedFAB({ Text("PCExtendedFAB") }, { OneIcon(OneIcons.Plus) }, {})
            SecondaryFAB({}) { OneIcon(OneIcons.Plus) }
            SecondaryExtendedFAB({ Text("SExtendedFAB") }, { OneIcon(OneIcons.Plus) }, {})
            SecondaryContainerFAB({}) { OneIcon(OneIcons.Plus) }
            SecondaryContainerExtendedFAB(
                { Text("SCEExtendedFAB") },
                { OneIcon(OneIcons.Plus) },
                {})
            TertiaryFAB({}) { OneIcon(OneIcons.Plus) }
            TertiaryExtendedFAB({ Text("TEExtendedFAB") }, { OneIcon(OneIcons.Plus) }, {})
            TertiaryContainerFAB({}) { OneIcon(OneIcons.Plus) }
            TertiaryContainerExtendedFAB({ Text("TCEExtendedFAB") }, { OneIcon(OneIcons.Plus) }, {})
        }
    }
}