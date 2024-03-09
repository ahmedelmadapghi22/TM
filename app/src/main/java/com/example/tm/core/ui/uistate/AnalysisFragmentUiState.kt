package com.example.tm.core.ui

sealed class AnalysisFragmentUiState {
    data class Default(var isDefault: Boolean) : AnalysisFragmentUiState()
    data class NormalWeightState(var normalWeight: String) : AnalysisFragmentUiState()
    data class WeightOfPipesState(var weightOfPipes: String) : AnalysisFragmentUiState()
    data class NetWeightState(var netWeight: String) : AnalysisFragmentUiState()
    data class NetWeightPriceState(var netWeightPrice: String) : AnalysisFragmentUiState()
    data class NormalWeightPriceState(var normalWeightPrice: String) : AnalysisFragmentUiState()
    data class MetersPriceState(var metersPrice: String) : AnalysisFragmentUiState()
    data class DifferenceNetAndNormalState(var differencePriceBetweenNetAndNormal: String) : AnalysisFragmentUiState()
    data class DifferenceMetersAndKilogramsState(var differencePriceBetweenMetersAndKilograms: String) : AnalysisFragmentUiState()
    data class WeightOfMeterState(var weightOfMeter: String) : AnalysisFragmentUiState()
    data class MetersInKiloState(var metersInKilo: String) : AnalysisFragmentUiState()
    data class MetersInTotalKiloState(var totalMeters: String) : AnalysisFragmentUiState()
    data class ResourceError(var err: Int) : AnalysisFragmentUiState()
    data class TextError(var err: T) : AnalysisFragmentUiState()

    data class Success<T>(var data: T) : AnalysisFragmentUiState()


}
