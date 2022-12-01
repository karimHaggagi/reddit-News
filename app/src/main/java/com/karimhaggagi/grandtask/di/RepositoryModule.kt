package com.karimhaggagi.grandtask.di

import com.karimhaggagi.grandtask.data.repository.RepositoryImp
import com.karimhaggagi.grandtask.domain.repository.NewsRepository
import org.koin.dsl.module

val repositoryModule = module {

    single<NewsRepository> {
        return@single RepositoryImp(get(),get())
    }
}