package com.example.tm.domain.usecases.invoice

import java.util.Calendar
import javax.inject.Inject

class GetCurrentDateUseCase @Inject constructor() {
    private val currentDate: Calendar = Calendar.getInstance()

    operator fun invoke(): String {
        val year = currentDate.get(Calendar.YEAR)
        val month = currentDate.get(Calendar.MONTH) + 1
        val day = currentDate.get(Calendar.DAY_OF_MONTH)
        return "$day-$month-$year"
    }


}