package com.mightysana.onecomposable.composable.scaffold

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.Dp
import com.mightysana.onecomposable.OneColor
import com.mightysana.onecomposable.OneShape
import com.mightysana.onecomposable.OneValue
import com.mightysana.onecomposable.Preview
import com.mightysana.onecomposable.composable.OneIcon
import com.mightysana.onecomposable.composable.OneIcons

object OneBottomBarDefaults {
    val selectedIndicatorColor: Color
        @Composable
        get() = OneColor.primary

    val containerColor: Color
        @Composable
        get() = OneColor.primaryContainer

    val shape: Shape
        @Composable
        get() = OneShape.large.copy(
            bottomStart = CornerSize(OneValue.notRounded),
            bottomEnd = CornerSize(OneValue.notRounded)
        )
}

data class OneTab(
    val iconSelected: ImageVector,
    val iconUnselected: ImageVector,
    val content: @Composable () -> Unit,
    val label: String,
    val route: String = label.lowercase()
)

@Composable
fun BottomBar(
    tabs: List<OneTab>,
    selectedTabIndex: Int,
    onTabClick: (Int, Int) -> Unit,
    modifier: Modifier = Modifier,
    selectedIndicatorColor: Color = OneBottomBarDefaults.selectedIndicatorColor,
    selectedContentColor: Color = contentColorFor(selectedIndicatorColor),
    containerColor: Color = OneBottomBarDefaults.containerColor,
    contentColor: Color = contentColorFor(containerColor),
    tonalElevation: Dp = NavigationBarDefaults.Elevation,
    windowInsets: WindowInsets = NavigationBarDefaults.windowInsets,
) {
    NavigationBar(
        modifier = modifier.clip(OneBottomBarDefaults.shape),
        containerColor = containerColor,
        contentColor = contentColor,
        tonalElevation = tonalElevation,
        windowInsets = windowInsets,
    ) {
        tabs.forEachIndexed { index, tab ->
            val selected = selectedTabIndex == index
            NavigationBarItem(
                colors = NavigationBarItemDefaults.colors().copy(
                    selectedIndicatorColor = selectedIndicatorColor,
                    selectedIconColor = selectedContentColor,
                    selectedTextColor = contentColor,
                    unselectedIconColor = contentColor,
                    unselectedTextColor = contentColor
                ),
                selected = selected,
                icon = {
                    OneIcon(
                        if (selected) tab.iconSelected else tab.iconUnselected
                    )
                },
                label = {
                    Text(
                        text = tab.label,
                        style = MaterialTheme.typography.labelSmall
                    )
                },
                onClick = {
                    if (!selected) {
                        val currentTab = selectedTabIndex
                        if(index != currentTab)
                            onTabClick(index, currentTab)
                    }
                }
            )
        }
    }
}

@PreviewLightDark
@Composable
fun BottomBarPreview() {
    val tabs = listOf(
        OneTab(
            iconSelected = OneIcons.DashboardSelected,
            iconUnselected = OneIcons.DashboardUnselected,
            label = "Home",
            content = {}
        ),
        OneTab(
            iconSelected = OneIcons.TransactionsSelected,
            iconUnselected = OneIcons.TransactionsUnselected,
            label = "Transactions",
            content = {}
        ),
        OneTab(
            iconSelected = OneIcons.WalletsSelected,
            iconUnselected = OneIcons.WalletsUnselected,
            label = "Wallets",
            content = {}
        ),
        OneTab(
            iconSelected = OneIcons.DebtsSelected,
            iconUnselected = OneIcons.DebtsUnselected,
            label = "Debts",
            content = {}
        )
    )

    Preview {
        Scaffold(
            bottomBar = {
                BottomBar(
                    tabs = tabs,
                    selectedTabIndex = 0,
                    onTabClick = { _, _ -> }
                )
            }
        ) { innerPadding->
            Text("Text", modifier = Modifier.padding(innerPadding))
        }
    }
}