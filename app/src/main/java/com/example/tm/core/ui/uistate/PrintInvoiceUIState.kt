package com.example.tm.core.ui.uistate

sealed class InvoiceUIState {
    data class Loading(var isLoading: Boolean) : InvoiceUIState()

    data class CurrentDate(var date: String) : InvoiceUIState()
    data class Success(var isSuccess: Boolean) : InvoiceUIState()
    data class Error(var errId: Int) : InvoiceUIState()


}