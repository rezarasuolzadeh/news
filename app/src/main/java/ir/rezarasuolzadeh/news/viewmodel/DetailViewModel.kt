package ir.rezarasuolzadeh.news.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.rezarasuolzadeh.news.model.NewsModel
import ir.rezarasuolzadeh.news.repository.NewsRepositoryImp
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: NewsRepositoryImp
) : ViewModel() {

    private val existNews = MutableLiveData<Boolean>()
    val existNewsLiveData: LiveData<Boolean>
        get() = existNews

    fun fetchExistNews(url: String) = viewModelScope.launch {
        existNews.value = (repository.existNews(url))
    }

    fun fetchDeleteNews(news: NewsModel) = viewModelScope.launch {
        repository.deleteNews(news)
        fetchExistNews(news.url)
    }

    fun fetchSaveNews(news: NewsModel) = viewModelScope.launch {
        repository.insertSavedNews(news)
        fetchExistNews(news.url)
    }

}