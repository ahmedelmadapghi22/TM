package com.example.tm.domain.usecases.analysis

object Preconditions {
    private const val dot = "."
    fun checkNumber(str: String): Boolean {

        return str.isNotBlank() && str.isNotEmpty() && str != dot
    }


}