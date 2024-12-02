package dev.brunofelix.pmovie.data.local.dao

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.filters.MediumTest
import com.google.common.truth.Truth.assertThat
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dev.brunofelix.pmovie.core.data.local.MovieDatabase
import dev.brunofelix.pmovie.core.data.local.entity.MovieEntity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject
import javax.inject.Named

@MediumTest
@HiltAndroidTest
@ExperimentalCoroutinesApi
class MovieDaoTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Inject
    @Named("test_db")
    lateinit var db: MovieDatabase

    @Before
    fun setUp() {
        hiltRule.inject()
    }

    @After
    fun tearDown() {
        db.close()
    }

    @Test
    fun test_getAll_whenDatabaseIsEmpty_returnEmptyList() = runTest {
        // Given - Nothing!

        // When
        val movies = db.movieDao.getAll().first()

        // Then
        assertThat(movies?.size).isEqualTo(0)
    }

    @Test
    fun test_getAll_whenDatabaseIsNotEmpty_returnListOrderedByTitle() = runTest {
        // Given
        val mockMovies = listOf(
            MovieEntity(id = 2, title = "Movie 5", imageUrl = "URL 2", voteAverage = 1F, duration = 1),
            MovieEntity(id = 5, title = "Movie 3", imageUrl = "URL 5", voteAverage = 1F, duration = 1),
            MovieEntity(id = 1, title = "Movie 4", imageUrl = "URL 1", voteAverage = 1F, duration = 1),
            MovieEntity(id = 4, title = "Movie 2", imageUrl = "URL 4", voteAverage = 1F, duration = 1),
            MovieEntity(id = 3, title = "Movie 1", imageUrl = "URL 3", voteAverage = 1F, duration = 1)
        )
        mockMovies.forEach {
            db.movieDao.insert(it)
        }

        // When
        val movies = db.movieDao.getAll().first()

        // Then
        assertThat(movies?.size).isEqualTo(5)
        assertThat(movies?.get(0)?.title).isEqualTo("Movie 1")
        assertThat(movies?.get(1)?.title).isEqualTo("Movie 2")
        assertThat(movies?.get(2)?.title).isEqualTo("Movie 3")
        assertThat(movies?.get(3)?.title).isEqualTo("Movie 4")
        assertThat(movies?.get(4)?.title).isEqualTo("Movie 5")
    }

    @Test
    fun test_getById_whenDatabaseIsEmpty_returnNull() = runTest {
        // Given - Nothing!

        // When
        val movie = db.movieDao.getById(1)

        // Then
        assertThat(movie).isNull()
    }

    @Test
    fun test_getById_whenDatabaseIsNotEmpty_returnMovie() = runTest {
        // Given
        val mockMovie = MovieEntity(
            id = 1,
            title = "Movie 1",
            imageUrl = "URL 1",
            voteAverage = 1F,
            duration = 1
        )
        db.movieDao.insert(mockMovie)

        // When
        val movie = db.movieDao.getById(1)

        // Then
        assertThat(movie?.title).isEqualTo("Movie 1")
    }

    @Test
    fun test_insert_whenMovieNotExists_returnMovieIdInserted() = runTest {
        // Given
        val mockMovie = MovieEntity(id = 107, title = "Movie 107", imageUrl = "URL 107", voteAverage = 1F, duration = 1)

        // When
        val movieIdInserted = db.movieDao.insert(mockMovie)
        val movies = db.movieDao.getAll().first()

        // Then
        assertThat(movieIdInserted).isEqualTo(107)
        assertThat(movies?.size).isEqualTo(1)
    }

    @Test
    fun test_insert_whenMovieAlreadyExists_returnMovieReplaced() = runTest {
        // Given
        val mockMovie1 = MovieEntity(id = 1, title = "Movie 1", imageUrl = "URL 1", voteAverage = 1F, duration = 1)
        db.movieDao.insert(mockMovie1)
        val mockMovie2 = MovieEntity(id = 1, title = "Movie Replaced", imageUrl = "URL 1", voteAverage = 1F, duration = 1)
        db.movieDao.insert(mockMovie2)

        // When
        val movies = db.movieDao.getAll().first()
        val movie = db.movieDao.getById(1)

        // Then
        assertThat(movies?.size).isEqualTo(1)
        assertThat(movie?.title).isEqualTo("Movie Replaced")
    }

    @Test
    fun test_delete_whenMovieExists_return1RowAffected() = runTest {
        // Given
        val mockMovie = MovieEntity(id = 1, title = "Movie 1", imageUrl = "URL 1", voteAverage = 1F, duration = 1)
        db.movieDao.insert(mockMovie)

        // When
        val result = db.movieDao.delete(mockMovie)
        val movies = db.movieDao.getAll().first()

        // Then
        assertThat(result).isEqualTo(1)
        assertThat(movies?.size).isEqualTo(0)
    }

    @Test
    fun test_delete_whenMovieNotExists_returnZeroRowsAffected() = runTest {
        // Given
        val mockMovie = MovieEntity(id = 1, title = "Movie 1", imageUrl = "URL 1", voteAverage = 1F, duration = 1)

        // When
        val result = db.movieDao.delete(mockMovie)

        // Then
        assertThat(result).isEqualTo(0)
    }
}