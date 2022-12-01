package com.karimhaggagi.grandtask.di

import com.karimhaggagi.grandtask.data.data_source.local.DatabaseBuilder.provideDao
import com.karimhaggagi.grandtask.data.data_source.local.DatabaseBuilder.provideDataBase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val localModule = module {
    single { provideDataBase(androidApplication()) }
    single { provideDao(get()) }
}