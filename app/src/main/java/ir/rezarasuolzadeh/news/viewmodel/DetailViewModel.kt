package ir.rezarasuolzadeh.news.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.rezarasuolzadeh.news.base.BaseViewModel
import ir.rezarasuolzadeh.news.model.NewsModel
import ir.rezarasuolzadeh.news.repository.NewsRepositoryImp
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: NewsRepositoryImp
) : BaseViewModel() {

    private val existNews = MutableLiveData<Boolean>()
    val existNewsLiveData: LiveData<Boolean>
        get() = existNews

    fun fetchExistNews(url: String) = viewModelScope.launch(exceptionHandler) {
        existNews.value = (repository.existNews(url))
    }

    fun fetchDeleteNews(news: NewsModel) = viewModelScope.launch(exceptionHandler) {
        repository.deleteNews(news)
        fetchExistNews(news.url)
    }

    fun fetchSaveNews(news: NewsModel) = viewModelScope.launch(exceptionHandler) {
        repository.insertSavedNews(news)
        fetchExistNews(news.url)
    }

}