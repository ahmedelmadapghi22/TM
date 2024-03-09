package com.example.tm.domain.usecases.analysis

import com.example.tm.domain.usecases.Preconditions
import java.math.RoundingMode
import java.text.DecimalFormat
import javax.inject.Inject

class CalculateDifferenceNormalAndNetUseCase @Inject constructor() {
    private val df = DecimalFormat("#.##")
    operator fun invoke(normalWeightPrice: String, netWeightPrice: String): String {
        df.roundingMode = RoundingMode.UP
        if (normalWeightPrice !="0" && netWeightPrice!="0") {

            return df.format(normalWeightPrice.toFloat() - netWeightPrice.toFloat()).toString()
        }
        return "0"
    }

}