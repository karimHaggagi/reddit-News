package com.karimhaggagi.grandtask.di

import com.karimhaggagi.grandtask.domain.use_case.GetNewsUseCase
import org.koin.dsl.module

val useCaseModule = module {

    single { GetNewsUseCase(get()) }

}