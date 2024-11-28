package dev.brunofelix.pmovie.core.presentation.components.navbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Movie
import androidx.compose.ui.graphics.vector.ImageVector
import dev.brunofelix.pmovie.core.presentation.navigation.Screen

sealed class BottomNavItem(
    val title: String,
    val route: String,
    val icon: ImageVector
) {
    data object Popular: BottomNavItem(
        title = Screen.Popular.title,
        route = Screen.Popular.route,
        icon = Icons.Default.Movie,
    )

    data object Upcoming: BottomNavItem(
        title = Screen.Upcoming.title,
        route = Screen.Upcoming.route,
        icon = Icons.Default.DateRange
    )

    data object Favorite: BottomNavItem(
        title = Screen.Favorite.title,
        route = Screen.Favorite.route,
        icon = Icons.Default.Favorite
    )
}