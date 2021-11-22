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

    private val isNewsSaved = MutableLiveData<Boolean>()
    val isNewsSavedLiveData: LiveData<Boolean>
        get() = isNewsSaved

    fun fetchHeadlineNews() = viewModelScope.launch {
//        isNewsSaved.value = (repository.getHeadlineNews())
    }

    fun addSavedNews(news: NewsModel) = viewModelScope.launch {
        repository.insertSavedNews(news)
        isNewsSaved.value = true
    }

}