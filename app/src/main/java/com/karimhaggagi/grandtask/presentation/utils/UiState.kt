package com.karimhaggagi.grandtask.presentation.utils

sealed class UiState<out T> {
    object Empty : UiState<Nothing>()
    object Loading : UiState<Nothing>()
    data class Success<out R>(val data: R) : UiState<R>()
    data class Error(val error: String) : UiState<Nothing>()
}
