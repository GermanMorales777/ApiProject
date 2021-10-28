package com.apolis.animsearch.api

import com.apolis.animsearch.data.AnimeSearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("search/anime")
    suspend fun searchAnime(@Query("q") q: String): Response<AnimeSearchResponse>
}