package com.example.tm.ui

import androidx.lifecycle.ViewModel
import com.example.tm.domain.usecases.analysis.CalculateNumberOfMetersInTotalWeightUseCase
import com.example.tm.domain.CalculatePriceUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val calculateNumberOfMetersInTotalWeightUseCase: CalculateNumberOfMetersInTotalWeightUseCase,
                                                private val calculatePriceUseCase: CalculatePriceUseCase

) :
    ViewModel() {
    private var _calculateMetersState: MutableStateFlow<Float> = MutableStateFlow(0f)
    val calculateMetersState = _calculateMetersState.asStateFlow()

    private var _calculatePriceState: MutableStateFlow<Float> = MutableStateFlow(0f)
    val calculatePriceState = _calculatePriceState.asStateFlow()
    fun calculateNumberOfMeters(weightOfPart: String, lengthOfPart: String, totalWeight: String) {

        val result = calculateNumberOfMetersInTotalWeightUseCase(weightOfPart, lengthOfPart, totalWeight)



    }
    fun calculatePrice(numberOfMeters: String, priceOfOneMeter: String) {

        val result = calculatePriceUseCase(numberOfMeters, priceOfOneMeter)

        _calculatePriceState.value = result


    }
}