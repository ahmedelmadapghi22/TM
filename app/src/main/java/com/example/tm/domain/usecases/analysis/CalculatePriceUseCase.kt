package com.example.tm.domain.usecases.analysis

import com.example.tm.domain.usecases.Preconditions
import java.math.RoundingMode
import java.text.DecimalFormat
import javax.inject.Inject

class CalculateWeightPriceUseCase @Inject constructor() {
    private val df = DecimalFormat("#.##")
    operator fun invoke(weight: String, priceOfOneKilo: String): String {
        df.roundingMode = RoundingMode.UP
        if (weight !="0" && Preconditions.checkNumber(priceOfOneKilo)) {

            return df.format(weight.toFloat() * priceOfOneKilo.toInt()).toString()
        }
        return "0"
    }

}