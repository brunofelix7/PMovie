package dev.brunofelix.pmovie.feature.movie.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import dev.brunofelix.pmovie.R
import dev.brunofelix.pmovie.core.presentation.ui.Colors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieDetailsTopBar(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit
) {
    TopAppBar(
        title = {
            Text(text = "")
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = Colors.blackPrimary
        ),
        navigationIcon = {
            IconButton(
                onClick = onBackClick
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBackIosNew,
                    tint = Colors.white,
                    contentDescription = stringResource(R.string.top_bar_favorite_icon)
                )
            }
        },
        actions = {
            IconButton(
                onClick = {
                    // TODO: Save to favorites
                }
            ) {
                // TODO: Check if it was already saved
                Icon(
                    imageVector = Icons.Outlined.FavoriteBorder,
                    tint = Colors.white,
                    contentDescription = stringResource(R.string.top_bar_favorite_icon)
                )
            }
        },
        modifier = modifier.fillMaxWidth()
    )
}

@Preview
@Composable
private fun MovieDetailsTopBarPreview() {
    MovieDetailsTopBar {

    }
}