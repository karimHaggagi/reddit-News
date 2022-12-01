package com.karimhaggagi.grandtask.di
import com.karimhaggagi.grandtask.presentation.ui.home.NewsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { NewsViewModel(get()) }

}