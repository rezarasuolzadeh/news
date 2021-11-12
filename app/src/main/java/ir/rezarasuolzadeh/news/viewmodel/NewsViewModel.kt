package ir.rezarasuolzadeh.news.viewmodel

import androidx.lifecycle.*
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

    fun fetchHeadlineNews() = viewModelScope.launch {
        headlineNews.postValue(repository.getHeadlineNews("iran"))
    }

}