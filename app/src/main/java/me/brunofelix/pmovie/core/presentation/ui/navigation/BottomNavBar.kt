package me.brunofelix.pmovie.core.presentation.ui.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import me.brunofelix.pmovie.core.presentation.ui.theme.black
import me.brunofelix.pmovie.core.presentation.ui.theme.yellow

@Composable
fun BottomNavBar(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val items = listOf(
        BottomNavItem.Popular,
        BottomNavItem.Upcoming,
        BottomNavItem.Favorite
    )

    NavigationBar(
        containerColor = black,
        modifier = modifier
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { currentItem ->
            val selectedItemColor = if (currentRoute == currentItem.route) yellow else Color.Gray

            NavigationBarItem(
                selected = currentRoute == currentItem.route,
                icon = {
                    Icon(
                        imageVector = currentItem.icon,
                        contentDescription = "",
                        tint = selectedItemColor
                    )
                },
                label = {
                    Text(
                        text = currentItem.title,
                        color = selectedItemColor
                    )
                },
                onClick = {
                    navController.navigate(currentItem.route) {
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun BottomNavBarPreview() {
    BottomNavBar(
        navController = rememberNavController()
    )
}