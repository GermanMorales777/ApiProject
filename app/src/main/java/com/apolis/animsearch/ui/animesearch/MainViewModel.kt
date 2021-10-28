package com.apolis.animsearch.ui.animesearch

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apolis.animsearch.api.Repository
import com.apolis.animsearch.data.Anime
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel(val repository: Repository): ViewModel() {
    val query = MutableLiveData<String>()
    val searchResults = MutableLiveData<List<Anime>>()
    val processing = ObservableField<Boolean>()
    val error = MutableLiveData<String>()

    fun searchAnime() {

        viewModelScope.launch(Dispatchers.IO) {
            if(query.value == null ) {
                error.postValue("Please enter search keyword")
                return@launch
            }

            if(query.value?.isEmpty() != false) {
                error.postValue("Please enter search keyword")
                return@launch
            }

            try {
                processing.set(true)
                val response = repository.searchAnime(query.value?:"")
                processing.set(false)
                if(!response.isSuccessful) {
                    error.postValue("Something went wrong. Error code: ${response.code()}. Please retry.")
                    return@launch
                }
                response.body()?.let {
                    searchResults.postValue(it.results)
                    if(it.results.isEmpty()) {
                        error.postValue("No data found for given input")
                    }
                }
            } catch (e: Exception) {
                processing.set(false)
                error.postValue("Something went wrong. Please retry.")
            }
        }

    }
}