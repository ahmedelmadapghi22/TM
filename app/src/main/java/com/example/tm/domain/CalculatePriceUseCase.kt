package com.example.tm.domain

import javax.inject.Inject

class CalculatePriceUseCase @Inject constructor() {
    operator fun invoke(numberOfMeters: String, priceOfOneMeter: String): Float {
        if ((numberOfMeters.isNotEmpty() && numberOfMeters != "0") && priceOfOneMeter.isNotEmpty() && priceOfOneMeter != "0") {
            return numberOfMeters.toFloat() * priceOfOneMeter.toFloat()
        }
        return 0.0f
    }

}