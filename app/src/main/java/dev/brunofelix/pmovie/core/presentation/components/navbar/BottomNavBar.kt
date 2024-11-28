package dev.brunofelix.pmovie.core.presentation.components.navbar

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dev.brunofelix.pmovie.core.presentation.ui.Colors

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
        containerColor = Colors.blackPrimary,
        modifier = modifier
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { currentItem ->
            val selectedItemColor = if (currentRoute == currentItem.route) {
                Colors.redPrimary
            } else {
                Colors.lightGray
            }

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