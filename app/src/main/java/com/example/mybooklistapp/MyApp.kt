package com.example.mybooklistapp

import android.app.Application

class MyApp : Application() {

    companion object{
        lateinit var bookRepo: BookRepository
    }

    override fun onCreate() {
        super.onCreate()
        bookRepo = BookRepository()
    }
}