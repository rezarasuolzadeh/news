package ir.rezarasuolzadeh.news.viewmodel

import android.app.Application
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

    private val _headlineNews: MutableLiveData<List<NewsModel>> = MutableLiveData()
    val headlineNews: LiveData<List<NewsModel>> = _headlineNews

    fun fetchHeadlineNews() = viewModelScope.launch {
        _headlineNews.postValue(repository.getHeadlineNews("iran"))
    }

}