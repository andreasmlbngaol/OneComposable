package com.mightysana.onecomposable.composable.scaffold

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.Dp
import com.mightysana.onecomposable.OneColor
import com.mightysana.onecomposable.composable.OneIcon
import com.mightysana.onecomposable.composable.OneIcons
import com.mightysana.onecomposable.Preview

object OneTopBarDefaults {
    val containerColor: Color
        @Composable
        get() = OneColor.primaryContainer

    val scrolledContainerColor: Color
        @Composable
        get() = OneColor.primary
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OneCenterTopBar(
    title: @Composable (() -> Unit),
    modifier: Modifier = Modifier,
    navigationIcon: @Composable (() -> Unit) = {},
    actions: @Composable (RowScope.() -> Unit) = {},
    expandedHeight: Dp = TopAppBarDefaults.TopAppBarExpandedHeight,
    windowInsets: WindowInsets = TopAppBarDefaults.windowInsets,
    containerColor: Color = OneTopBarDefaults.containerColor,
    scrolledContainerColor: Color = OneTopBarDefaults.scrolledContainerColor,
    navigationIconContentColor: Color = contentColorFor(containerColor),
    actionIconContentColor: Color = contentColorFor(containerColor),
    titleContentColor: Color = contentColorFor(containerColor),
    scrollBehavior: TopAppBarScrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
) {
    CenterAlignedTopAppBar(
        title = title,
        modifier = modifier,
        navigationIcon = navigationIcon,
        actions = actions,
        expandedHeight = expandedHeight,
        windowInsets = windowInsets,
        colors = TopAppBarColors(
            containerColor,
            scrolledContainerColor,
            navigationIconContentColor,
            titleContentColor,
            actionIconContentColor
        ),
        scrollBehavior = scrollBehavior
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OneTopBar(
    title: @Composable (() -> Unit),
    modifier: Modifier = Modifier,
    navigationIcon: @Composable (() -> Unit) = {},
    actions: @Composable (RowScope.() -> Unit) = {},
    expandedHeight: Dp = TopAppBarDefaults.TopAppBarExpandedHeight,
    windowInsets: WindowInsets = TopAppBarDefaults.windowInsets,
    containerColor: Color = OneTopBarDefaults.containerColor,
    scrolledContainerColor: Color = OneTopBarDefaults.scrolledContainerColor,
    navigationIconContentColor: Color = contentColorFor(containerColor),
    actionIconContentColor: Color = contentColorFor(containerColor),
    titleContentColor: Color = contentColorFor(containerColor),
    scrollBehavior: TopAppBarScrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
) {
    TopAppBar(
        title = title,
        modifier = modifier,
        navigationIcon = navigationIcon,
        actions = actions,
        expandedHeight = expandedHeight,
        windowInsets = windowInsets,
        colors = TopAppBarColors(
            containerColor,
            scrolledContainerColor,
            navigationIconContentColor,
            titleContentColor,
            actionIconContentColor
        ),
        scrollBehavior = scrollBehavior
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@PreviewLightDark
@Composable
fun OneCenterTopBarPreview() {
    Preview {
        Scaffold(
            topBar = {
                OneTopBar(
                    title = { Text("Test") },
                    navigationIcon = { IconButton({}) { OneIcon(OneIcons.Back) } },
                    actions = { IconButton({}) { OneIcon(OneIcons.Profile) } },
                    containerColor = OneColor.primaryContainer
                )
            }
        ) { innerPadding ->
            Text("Test", modifier = Modifier.padding(innerPadding))
        }
    }
}