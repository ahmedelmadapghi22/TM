package com.example.tm.domain

import com.example.tm.domain.usecases.Preconditions
import com.example.tm.domain.usecases.analysis.CalculateMetersInKiloUseCase
import com.example.tm.domain.usecases.analysis.RoundDecimalUseCase
import javax.inject.Inject

class CalculateNumberOfMetersInTotalWeightUseCase @Inject constructor(private val calculateMetersInKiloUseCase: CalculateMetersInKiloUseCase) :
    RoundDecimalUseCase() {
    operator fun invoke(weightOfPart: String, lengthOfPart: String, totalWeight: String): String {
        val metersInKilo = calculateMetersInKiloUseCase(weightOfPart, lengthOfPart)
        if (Preconditions.checkNumber(metersInKilo) && Preconditions.checkNumber(totalWeight)) {
          return  roundDecimal.getRound().format(metersInKilo.toFloat() * totalWeight.toFloat())
        }
        return "0"
    }

}