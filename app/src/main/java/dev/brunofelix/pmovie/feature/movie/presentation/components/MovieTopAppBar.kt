package dev.brunofelix.pmovie.feature.movie.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import dev.brunofelix.pmovie.R
import dev.brunofelix.pmovie.core.presentation.ui.Colors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieTopAppBar(
    title: String,
    modifier: Modifier = Modifier
) {
    MediumTopAppBar(
        title = {
            Text(
                text = title,
                color = Color.White
            )
        },
        colors = TopAppBarDefaults.largeTopAppBarColors(
            containerColor = Colors.blackPrimary
        ),
        modifier = modifier.fillMaxWidth()
    )
}

@Preview(showBackground = true)
@Composable
private fun MovieTopAppBarPreview() {
    MovieTopAppBar(title = stringResource(R.string.upcoming))
}