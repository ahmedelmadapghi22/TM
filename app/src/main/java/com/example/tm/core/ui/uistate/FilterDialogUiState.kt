package com.example.tm.core.ui.uistate

import com.example.tm.domain.model.Material

sealed class MaterialsFragmentUiState {
    data class Loading(var isLoading: Boolean) : MaterialsFragmentUiState()

    data class Success(var data: List<Material>) : MaterialsFragmentUiState()
    data class Empty(var isEmpty: Boolean) : MaterialsFragmentUiState()

    data class TextError(var err: String) : MaterialsFragmentUiState()


}