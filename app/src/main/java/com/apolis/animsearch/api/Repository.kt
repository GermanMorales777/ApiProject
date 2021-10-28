package com.apolis.animsearch.api

class Repository(val apiService: ApiService) {

    suspend fun searchAnime(q: String) = apiService.searchAnime(q)
}