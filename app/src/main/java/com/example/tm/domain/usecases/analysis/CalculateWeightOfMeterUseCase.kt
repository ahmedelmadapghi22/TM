package com.example.tm.domain

import android.util.Log
import javax.inject.Inject

class CalculateNumberOfMeterUseCase @Inject constructor() {
    //0.5kg length 0.25 numOf Part in total = totalWeight / weightPart = 200/0.25
    operator fun invoke(weightOfPart: String, lengthOfPart: String, totalWeight: String): Float {
        val numPartsInTotal: Float

        if ((weightOfPart.isNotEmpty() && weightOfPart != ".") && (totalWeight.isNotEmpty() && totalWeight != ".") && (lengthOfPart.isNotEmpty() && lengthOfPart != ".")) {
            numPartsInTotal = totalWeight.toFloat() / weightOfPart.toFloat()
            if (numPartsInTotal != 0f) {

                return  numPartsInTotal * lengthOfPart.toFloat()
            }
        }
        return 0f
    }

}