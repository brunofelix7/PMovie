package me.brunofelix.pmovie.feature.movie.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import me.brunofelix.pmovie.core.domain.model.Movie
import me.brunofelix.pmovie.core.util.logError
import me.brunofelix.pmovie.feature.movie.domain.source.MovieRemoteDataSource
import retrofit2.HttpException
import java.io.IOException

class MoviePopularPagingSource(
    private val dataSource: MovieRemoteDataSource
) : PagingSource<Int, Movie>() {

    private val pageLimit = 20

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition?.let { position ->
            val anchorPage = state.closestPageToPosition(position)
            anchorPage?.prevKey?.plus(pageLimit) ?: anchorPage?.nextKey?.minus(pageLimit)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        return try {
            val page = params.key ?: 1
            val response = dataSource.getPopular(page).body()
            val movies = response?.results?.map { it.toMovie() }
            LoadResult.Page(
                data = movies ?: emptyList(),
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (movies.isNullOrEmpty()) null else page + 1
            )
        } catch (e: IOException) {
            logError("$e")
            LoadResult.Error(e)
        } catch (e: HttpException) {
            logError("$e")
            LoadResult.Error(e)
        }
    }
}