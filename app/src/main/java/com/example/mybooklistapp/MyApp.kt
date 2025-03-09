package com.example.mybooklistapp

import android.app.Application

class MyApp : Application() {

    /**
     * companion object for book repository
     */
    companion object{
        lateinit var bookRepo: BookRepository
    }

    /**
     * on create method
     */
    override fun onCreate() {
        super.onCreate()
        bookRepo = BookRepository()
    }
}