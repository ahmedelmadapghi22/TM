package com.example.tm.core.ui.uistate

sealed class GoodsFragmentUIState {

    data class Loading(var isLoading: Boolean) : GoodsFragmentUIState()
    data class Date(var date: String) : GoodsFragmentUIState()
    data class MaterialData(var materialName: String, var materialID: Int) :
        GoodsFragmentUIState()

    data class SuccessInsert(var isSaved: Boolean) : GoodsFragmentUIState()
    data class ResourceError(var errId: Int) : GoodsFragmentUIState()
    data class TextError(var err: String) : GoodsFragmentUIState()


}