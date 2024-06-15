package me.brunofelix.pmovie.core.data.remote

import me.brunofelix.pmovie.core.data.remote.dto.MovieDto
import me.brunofelix.pmovie.core.data.remote.dto.ResultDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {
    @GET("movie/popular")
    suspend fun getPopular(
        @Query("page") page: Int
    ): Response<MovieDto>

    @GET("movie/upcoming")
    suspend fun getUpcoming(
        @Query("page") page: Int
    ): Response<MovieDto>

    @GET("movie/{id}")
    suspend fun getDetails(
        @Path("id") id: Int
    ): Response<ResultDto>

    @GET("search/movie")
    suspend fun search(
        @Query("query") query: String,
        @Query("page") page: Int
    ): Response<MovieDto>
}