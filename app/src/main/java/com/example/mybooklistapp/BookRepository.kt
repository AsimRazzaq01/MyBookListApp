package com.example.mybooklistapp

import kotlin.String.*

class BookRepository {

    private var appName = String ;
    private var appDeveloper = String ;
    private var appVersion = String ;
    private var bookList: MutableList<Book> = mutableListOf()

    init {
        bookList.addAll(
            listOf(
                Book("Joy Buolamwini Biography: Championing Humanity in the Age of AI", "Biography", 16.96),
                Book("Ada Lovelace: A Life from Beginning to End, Biography ","Biography",9.99),
                Book("Alan Turing: The Enigma", "Biography", 8.50),
                Book("Trust", "Science Fiction",10.17),
                Book("Dark Matter", "Science Fiction", 9.16),
                Book("The Midnight Library","Science Fiction",9.54),
                Book("Atomic Habits: An Easy & Proven Way to Build Good Habits & Break Bad Ones","Self-help", 15.00),
                Book("Happiness is Choice", "Self-help",15.00),
                Book("Get Out of Your Head: Stopping the Spiral of Toxic Thoughts", "Self-help", 13.73)
            )
        )
    }

    fun getAppName() {
        appName
    }
    fun getAppDeveloperName(){
        appDeveloper
    }
    fun getAppVersion(){
        appVersion
    }
    fun getBooks(){
        bookList
    }
    fun getAveragePrice(){
        bookList.map { it.price }.average()
    }
    fun getGenreAveragePrice(genre: String){
        bookList.filter { it.genre == genre }.map { it.price }.average()
    }




}