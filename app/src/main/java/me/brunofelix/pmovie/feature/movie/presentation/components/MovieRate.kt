package me.brunofelix.pmovie.feature.movie.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.brunofelix.pmovie.core.presentation.ui.BlackPrimary

@Composable
fun MovieRate(
    rate: Float,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.background(BlackPrimary)
    ) {
        Icon(
            imageVector = Icons.Default.Star,
            tint = Color.Yellow,
            contentDescription = "",
            modifier = modifier.size(12.dp)
        )
        Text(
            text = rate.toString(),
            style = MaterialTheme.typography.bodyMedium,
            color = Color.White,
            fontSize = 10.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun MovieRatePreview() {
    MovieRate(rate = 7.5F)
}