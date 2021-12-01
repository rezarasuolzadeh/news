package ir.rezarasuolzadeh.news.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.rezarasuolzadeh.news.base.BaseViewModel
import ir.rezarasuolzadeh.news.model.NewsModel
import ir.rezarasuolzadeh.news.repository.NewsRepositoryImp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val repository: NewsRepositoryImp,
) : BaseViewModel() {

    private val headlineNews = MutableLiveData<List<NewsModel>>()
    val headlineNewsLiveData: LiveData<List<NewsModel>>
        get() = headlineNews

    private val technologyNews = MutableLiveData<List<NewsModel>>()
    val technologyNewsLiveData: LiveData<List<NewsModel>>
        get() = technologyNews

    fun fetchHeadlineNews() = viewModelScope.launch(exceptionHandler) {
        delay(5000)
        headlineNews.value = (repository.getHeadlineNews())
    }

    fun fetchTechnologyNews() = viewModelScope.launch(exceptionHandler) {
        technologyNews.postValue(repository.getOtherNews(q = "space"))
    }

    fun addSavedNews(news: NewsModel) = viewModelScope.launch {
        repository.insertSavedNews(news)
    }

}