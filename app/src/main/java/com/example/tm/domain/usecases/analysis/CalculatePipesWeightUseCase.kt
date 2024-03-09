package com.example.tm.domain.usecases.analysis

import androidx.core.text.isDigitsOnly
import javax.inject.Inject

class CalculatePipesWeightUseCase @Inject constructor() {
    operator fun invoke(weightOfOnePipe: String, numberOfPipes: String): String {

        if (numberOfPipes.isDigitsOnly()&& numberOfPipes.isDigitsOnly() &&  weightOfOnePipe!=".") {
            return (weightOfOnePipe.toFloat() * numberOfPipes.toInt()).toString()
        }
        return "0"
    }

}