package com.example.mybooklistapp

import kotlin.String.*

class BookRepository {
    /**
     * initializing member variables
     */
    private var appName : String = "";
    private var appDeveloper : String = "";
    private var appVersion : String = "";
    private var bookList: MutableList<Book> = mutableListOf()

    /**
     * init - adding data to member variables
     */
    init {
        appName = "Book App"
        appDeveloper = "Asim Razzaq"
        appVersion = "1.0"

        // Hardcode of Book instances
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

    /**
     * methods to return data variables
     */
    fun getAppName(): String {
        return appName
    }
    fun getAppDeveloperName(): String {
        return appDeveloper
    }
    fun getAppVersion(): String {
        return appVersion
    }
    fun getBooks(): List<Book>{
        return bookList
    }
    fun getAveragePrice(): Double{
        return  bookList.map { it.price }.average()
    }
    fun getGenreAveragePrice(genre: String): Double{
        return bookList.filter { it.genre == genre }.map { it.price }.average()
    }
    
}   // End BookRepository