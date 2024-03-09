package com.example.tm.ui.fragment.kilograms

import androidx.lifecycle.ViewModel
import com.example.tm.domain.usecases.analysis.CalculateNumberOfMetersInTotalWeightUseCase
import com.example.tm.domain.usecases.analysis.CalculatePriceDifferenceUseCase
import com.example.tm.domain.usecases.analysis.CalculateMetersInKiloUseCase
import com.example.tm.domain.usecases.analysis.CalculateNetWeightUseCase
import com.example.tm.domain.usecases.analysis.CalculatePipesWeightUseCase
import com.example.tm.domain.usecases.analysis.CalculateWeightOfMeterUseCase
import com.example.tm.domain.usecases.analysis.CalculatePriceUseCase
import com.example.tm.ui.AnalysisFragmentUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class AnalysisKilogramsViewModel @Inject constructor(
    private val calculatePipesWeightUseCase: CalculatePipesWeightUseCase,
    private val calculateNetWeightUseCase: CalculateNetWeightUseCase,
    private val calculatePriceUseCase: CalculatePriceUseCase,
    private val calculatePriceDifferenceUseCase: CalculatePriceDifferenceUseCase,
    private val calculateWeightOfMeterUseCase: CalculateWeightOfMeterUseCase,
    private val calculateMetersInKiloUseCase: CalculateMetersInKiloUseCase,
    private val metersInTotalWeightUseCase: CalculateNumberOfMetersInTotalWeightUseCase
) :
    ViewModel() {
    private val analysisFragmentUiState: MutableStateFlow<AnalysisFragmentUiState> =
        MutableStateFlow(AnalysisFragmentUiState.Default(false))
    val _analysisFragmentUiState =
        analysisFragmentUiState.asStateFlow()

    fun setSetNormalWeight(normalWeigh: String) {
        if (normalWeigh.isNotEmpty())
            analysisFragmentUiState.value = AnalysisFragmentUiState.NormalWeightState(normalWeigh)
        else
            analysisFragmentUiState.value = AnalysisFragmentUiState.NormalWeightState("0")

    }

    fun setWeightOfPipes(weightOfOnePipe: String, numberOfPipes: String) {

        analysisFragmentUiState.value = AnalysisFragmentUiState.WeightOfPipesState(
            calculatePipesWeightUseCase(
                weightOfOnePipe,
                numberOfPipes
            )
        )


    }

    fun setNetWeight(normalWeight: String, weightOfPipes: String) {

        analysisFragmentUiState.value = AnalysisFragmentUiState.NetWeightState(
            calculateNetWeightUseCase(
                normalWeight,
                weightOfPipes
            )
        )


    }

    fun setNetWeightPrice(netWeight: String, priceOfOneKilo: String) {

        analysisFragmentUiState.value = AnalysisFragmentUiState.NetWeightPriceState(
            calculatePriceUseCase(
                netWeight,
                priceOfOneKilo
            )
        )
    }

    fun setNormalWeightPrice(normalWeight: String, priceOfOneKilo: String) {
        analysisFragmentUiState.value = AnalysisFragmentUiState.NormalWeightPriceState(
            calculatePriceUseCase(
                normalWeight,
                priceOfOneKilo
            )
        )
    }
    fun setMetersPrice(meters: String, priceOfOneMeter: String) {
        analysisFragmentUiState.value = AnalysisFragmentUiState.MetersPriceState(
            calculatePriceUseCase(
                meters,
                priceOfOneMeter
            )
        )
    }

    fun setDifferencePriceBetweenNetAndNormal(normalWeightPrice: String, netWeightPrice: String) {
        analysisFragmentUiState.value = AnalysisFragmentUiState.DifferenceNetAndNormalState(
            calculatePriceDifferenceUseCase(
                normalWeightPrice,
                netWeightPrice
            )
        )
    }
    fun setDifferencePriceBetweenMetersAndKilograms(metersPrice: String, kilogramsPrice: String) {
        analysisFragmentUiState.value = AnalysisFragmentUiState.DifferenceMetersAndKilogramsState(
            calculatePriceDifferenceUseCase(
                metersPrice,
                kilogramsPrice
            )
        )
    }
    fun setWeightOfMeter(weightOfPart: String, lengthOfPart: String) {
        analysisFragmentUiState.value = AnalysisFragmentUiState.WeightOfMeterState(
            calculateWeightOfMeterUseCase(
                weightOfPart,
                lengthOfPart
            )
        )
    }

    fun setMetersInKilo(weightOfPart: String, lengthOfPart: String) {
        analysisFragmentUiState.value = AnalysisFragmentUiState.MetersInKiloState(
            calculateMetersInKiloUseCase(
                weightOfPart,
                lengthOfPart
            )
        )
    }

    fun setMetersInTotalKilo(weightOfPart: String, lengthOfPart: String, totalWeight: String) {
        analysisFragmentUiState.value = AnalysisFragmentUiState.MetersInTotalKiloState(
            metersInTotalWeightUseCase(
                weightOfPart, lengthOfPart, totalWeight
            )
        )
    }
}