package com.example.tm.domain.usecases.analysis

import java.math.RoundingMode
import java.text.DecimalFormat
import javax.inject.Inject

class CalculatePipesWeightUseCase @Inject constructor() {
    private val df = DecimalFormat("#.##")
    operator fun invoke(weightOfOnePipe: String, numberOfPipes: String): String {
        df.roundingMode = RoundingMode.UP
        if (Preconditions.checkNumber(weightOfOnePipe) && Preconditions.checkNumber(numberOfPipes)) {

            return df.format(weightOfOnePipe.toFloat() * numberOfPipes.toInt()).toString()
        }
        return "0"
    }

}