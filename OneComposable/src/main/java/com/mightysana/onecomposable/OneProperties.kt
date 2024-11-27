package com.mightysana.onecomposable

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Suppress("unused")
object OneColor {
    val primary
        @Composable
        get() = MaterialTheme.colorScheme.primary

    val primaryContainer
        @Composable
        get() = MaterialTheme.colorScheme.primaryContainer

    val secondary
        @Composable
        get() = MaterialTheme.colorScheme.secondary

    val secondaryContainer
        @Composable
        get() = MaterialTheme.colorScheme.secondaryContainer

    val tertiary
        @Composable
        get() = MaterialTheme.colorScheme.tertiary

    val tertiaryContainer
        @Composable
        get() = MaterialTheme.colorScheme.tertiaryContainer

    val background
        @Composable
        get() = MaterialTheme.colorScheme.background

    val surface
        @Composable
        get() = MaterialTheme.colorScheme.surface

    val surfaceVariant
        @Composable
        get() = MaterialTheme.colorScheme.surfaceVariant

    val error
        @Composable
        get() = MaterialTheme.colorScheme.error

    val errorContainer
        @Composable
        get() = MaterialTheme.colorScheme.errorContainer
}

@Suppress("unused")
object OneShape {
    val extraSmall
        @Composable
        get() = MaterialTheme.shapes.extraSmall

    val small
        @Composable
        get() = MaterialTheme.shapes.small

    val medium
        @Composable
        get() = MaterialTheme.shapes.medium

    val large
        @Composable
        get() = MaterialTheme.shapes.large

    val extraLarge
        @Composable
        get() = MaterialTheme.shapes.extraLarge
}

@Suppress("unused")
object OneValue {
    const val ALPHA = 0.4f
    val FormMaxWidth = 350.dp
    val Padding = 16.dp
    val SmallPadding = 8.dp
    val ExtraSmallPadding = 4.dp
    val NotRounded = 0.dp
    const val USERS_COLLECTION = "users"
    const val FRIEND_REQUESTS_COLLECTION = "friendRequests"
    const val FRIENDS_COLLECTION = "friends"
    const val FRIEND_LIST = "FriendList"
    const val PROFILE = "Profile"
    const val SETTINGS = "Settings"
    const val SEARCH = "Search"
    const val NOTIFICATIONS = "Notifications"
}

object OneImage {
    val LauncherIcon
        @Composable
        get() = painterResource(R.drawable.ic_launcher_foreground)
}

