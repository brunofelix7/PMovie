package me.brunofelix.pmovie.feature.movie.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import coil.compose.AsyncImage
import coil.request.ImageRequest
import me.brunofelix.pmovie.R
import me.brunofelix.pmovie.core.domain.model.Movie
import me.brunofelix.pmovie.core.presentation.ui.BlackPrimary

@Composable
fun MovieItem(
    movie: Movie,
    modifier: Modifier = Modifier,
    onItemClick: (id: Int) -> Unit
) {
    Box(
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .zIndex(2F)
                .padding(start = 8.dp, bottom = 8.dp)
        ) {
            MovieRate(rate = movie.voteAverage)
        }
        Card(
            shape = RoundedCornerShape(6.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
                .padding(4.dp)
                .clickable {
                    onItemClick(movie.id)
                }
        ) {
            Box {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(movie.imageUrl)
                        .crossfade(true)
                        .error(R.drawable.ic_error_image)
                        .placeholder(R.mipmap.ic_launcher)
                        .build(),
                    contentScale = ContentScale.FillHeight,
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.Center)
                        .background(BlackPrimary)
                        .clip(RoundedCornerShape(6.dp))
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MovieItemPreview() {
    val movie = Movie(id = 1, title = "Movie 1", imageUrl = "", voteAverage = 9.1F)
    MovieItem(movie) {

    }
}