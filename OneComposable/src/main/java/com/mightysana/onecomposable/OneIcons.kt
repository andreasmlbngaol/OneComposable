package com.mightysana.onecomposable

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AlternateEmail
import androidx.compose.material.icons.filled.Analytics
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Man
import androidx.compose.material.icons.filled.MarkEmailUnread
import androidx.compose.material.icons.filled.MonetizationOn
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Person2
import androidx.compose.material.icons.filled.QuestionMark
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.filled.Savings
import androidx.compose.material.icons.filled.Wc
import androidx.compose.material.icons.filled.Woman
import androidx.compose.material.icons.outlined.Analytics
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.MonetizationOn
import androidx.compose.material.icons.outlined.Savings
import androidx.compose.ui.graphics.vector.ImageVector

object OneIcons {
    val Plus: ImageVector = Icons.Default.Add
    val Minus: ImageVector = Icons.Default.Remove
    val DashboardSelected: ImageVector = Icons.Filled.Home
    val DashboardUnselected: ImageVector = Icons.Outlined.Home
    val TransactionsSelected: ImageVector = Icons.Filled.Analytics
    val TransactionsUnselected: ImageVector = Icons.Outlined.Analytics
    val WalletsSelected: ImageVector = Icons.Filled.Savings
    val WalletsUnselected: ImageVector = Icons.Outlined.Savings
    val DebtsSelected: ImageVector = Icons.Filled.MonetizationOn
    val DebtsUnselected: ImageVector = Icons.Outlined.MonetizationOn
    val Profile: ImageVector = Icons.Filled.Person
    val Email: ImageVector = Icons.Default.AlternateEmail
    val Logout: ImageVector = Icons.AutoMirrored.Filled.Logout
    val Password: ImageVector = Icons.Default.Password
    val ConfirmPassword: ImageVector = Icons.Default.Password
    val EmailVerification: ImageVector = Icons.Default.MarkEmailUnread
    val Name: ImageVector = Icons.Default.Person2
    val Gender: ImageVector = Icons.Default.Wc
    val Male: ImageVector = Icons.Default.Man
    val Female: ImageVector = Icons.Default.Woman
    val DropdownExpanded: ImageVector = Icons.Default.ArrowDropUp
    val DropdownCollapsed: ImageVector = Icons.Default.ArrowDropDown
    fun dropdown(expanded: Boolean): ImageVector = if (expanded) DropdownExpanded else DropdownCollapsed
    val DatePicker: ImageVector = Icons.Default.DateRange
    val Secret: ImageVector = Icons.Default.QuestionMark
}
