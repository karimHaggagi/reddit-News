package com.karimhaggagi.grandtask.presentation.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.karimhaggagi.grandtask.data.data_source.local.DatabaseNews
import com.karimhaggagi.grandtask.domain.model.NewsModel
import com.karimhaggagi.grandtask.domain.use_case.GetNewsUseCase
import com.karimhaggagi.grandtask.presentation.utils.UiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class NewsViewModel(private val newsUseCase: GetNewsUseCase) : ViewModel() {


    private val _newsLisStateFlow = MutableStateFlow<List<DatabaseNews>>(emptyList())
    val newsLisStateFlow = _newsLisStateFlow.asStateFlow()

    private val _networkStateFlow = MutableStateFlow<UiState<Boolean>>(UiState.Empty)
    val networkStateFlow = _networkStateFlow.asStateFlow()


    init {
        getFromDataBase()
        refreshList()
    }

    private fun getFromDataBase() {
        viewModelScope.launch {
            newsUseCase.getNews().collectLatest {
                _newsLisStateFlow.emit(it)
            }
        }
    }

    private fun refreshList() {
        viewModelScope.launch(Dispatchers.IO) {
            newsUseCase.refreshNewsList().collectLatest {
                _networkStateFlow.emit(it)
            }
        }
    }

}
