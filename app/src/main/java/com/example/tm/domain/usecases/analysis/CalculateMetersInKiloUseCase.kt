package com.example.tm.domain.usecases.analysis

import com.example.tm.domain.usecases.Preconditions
import java.text.DecimalFormat
import javax.inject.Inject

class CalculateWeightOfMeterUseCase @Inject constructor() {
    /* length of part = 0.4 cm and weight of part = 0.3 what is the weight of one meter
    (1 meter / length of part) * weightOfPart
    */
    private val df = DecimalFormat("#.##")
    operator fun invoke(weightOfPart: String, lengthOfPart: String): String {

        if (Preconditions.checkNumber(weightOfPart) && Preconditions.checkNumber(lengthOfPart)) {
            return df.format((1 / lengthOfPart.toFloat()) * weightOfPart.toFloat()).toString()

        }
        return "0"
    }

}