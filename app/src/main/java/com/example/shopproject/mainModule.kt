package com.example.shopproject

import com.example.shopproject.ViewModel.BrandViewModel
import com.example.shopproject.ViewModel.MainViewModel
import com.google.firebase.database.FirebaseDatabase
import org.koin.dsl.module

val mainModule = module {
    single<FirebaseDatabase>{
        FirebaseDatabase.getInstance()
    }
    single { MainViewModel(get()) }
    single { BrandViewModel(get()) }
}