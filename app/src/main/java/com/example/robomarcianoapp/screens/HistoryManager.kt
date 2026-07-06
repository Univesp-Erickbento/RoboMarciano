package com.example.robomarcianoapp

object HistoryManager {

    private val history = mutableListOf<String>()

    fun add(message: String) {
        history.add(message)
    }

    fun getAll(): List<String> {
        return history.reversed()
    }

    fun clear() {
        history.clear()
    }
}