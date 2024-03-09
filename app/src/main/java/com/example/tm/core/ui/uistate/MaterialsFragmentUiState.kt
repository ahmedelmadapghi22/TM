package com.example.tm.core.ui.uistate

sealed class MainUiState {
    data class ResourceError(var err: Int) : MainUiState()
    data class TextError(var err: String) : MainUiState()

    data class Success<T>(var data: T) : AnalysisFragmentUiState()

}