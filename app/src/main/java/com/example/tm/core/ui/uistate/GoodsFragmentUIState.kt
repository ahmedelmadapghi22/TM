package com.example.tm.core.ui.uistate

import com.example.tm.domain.model.Invoice

sealed class InvoiceUIState {
    data class Default(
        val materialName: String = "",
        var totalWeight: String = "",
        var totalMeters: String = "",
        var price: String = ""
    ) : InvoiceUIState()

    data class Success(var invoice: Invoice) : InvoiceUIState()
    data class Error(var errId: Int) : InvoiceUIState()


}