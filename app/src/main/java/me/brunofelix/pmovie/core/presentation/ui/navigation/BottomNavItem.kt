package me.brunofelix.pmovie.core.presentation.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Movie
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(
    val title: String,
    val icon: ImageVector,
    val route: String
) {
    data object Popular: BottomNavItem(
        title = "Popular",
        icon = Icons.Default.Movie,
        route = Screen.Popular.route
    )

    data object Upcoming: BottomNavItem(
        title = "Upcoming",
        icon = Icons.Default.DateRange,
        route = Screen.Upcoming.route
    )

    data object Favorite: BottomNavItem(
        title = "Favorite",
        icon = Icons.Default.Favorite,
        route = Screen.Favorite.route
    )
}