package me.brunofelix.pmovie.core.presentation.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Movie
import androidx.compose.ui.graphics.vector.ImageVector
import me.brunofelix.pmovie.core.util.Routes

sealed class BottomNavItem(
    val title: String,
    val icon: ImageVector,
    val route: String
) {
    data object Popular: BottomNavItem(
        title = "Popular",
        icon = Icons.Default.Movie,
        route = Routes.popularScreen
    )

    data object Upcoming: BottomNavItem(
        title = "Upcoming",
        icon = Icons.Default.CalendarToday,
        route = Routes.upcomingScreen
    )

    data object Favorite: BottomNavItem(
        title = "Favorite",
        icon = Icons.Default.Favorite,
        route = Routes.favoritesScreen
    )
}