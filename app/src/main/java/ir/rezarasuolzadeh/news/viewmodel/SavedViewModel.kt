package ir.rezarasuolzadeh.news.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.rezarasuolzadeh.news.base.BaseViewModel
import ir.rezarasuolzadeh.news.model.NewsModel
import ir.rezarasuolzadeh.news.repository.NewsRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SavedViewModel @Inject constructor(
    private val repository: NewsRepository
) : BaseViewModel() {

    private val savedNews = MutableLiveData<List<NewsModel>>()
    val savedNewsLiveData: LiveData<List<NewsModel>>
        get() = savedNews

    fun fetchSavedNews() = viewModelScope.launch(exceptionHandler) {
        savedNews.postValue(repository.getSavedNews())
    }

}