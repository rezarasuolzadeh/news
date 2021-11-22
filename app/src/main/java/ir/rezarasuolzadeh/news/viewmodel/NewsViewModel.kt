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
class NewsViewModel @Inject constructor(
    private val repository: NewsRepositoryImp,
) : ViewModel() {

    private val headlineNews = MutableLiveData<List<NewsModel>>()
    val headlineNewsLiveData: LiveData<List<NewsModel>>
        get() = headlineNews

    private val technologyNews = MutableLiveData<List<NewsModel>>()
    val technologyNewsLiveData: LiveData<List<NewsModel>>
        get() = technologyNews

    fun fetchHeadlineNews() = viewModelScope.launch {
        headlineNews.value = (repository.getHeadlineNews())
    }

    fun fetchTechnologyNews() = viewModelScope.launch {
        technologyNews.postValue(repository.getOtherNews(q = "space"))
    }

    fun addSavedNews(news: NewsModel) = viewModelScope.launch {
        repository.insertSavedNews(news)
    }

}