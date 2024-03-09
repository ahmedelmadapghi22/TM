package com.example.tm.core.ui.uistate

import com.example.tm.domain.model.Invoice

sealed class InvoiceUIState {
    data class Default(
        val materialName: String? = "",
        var quantity: String? = "",
        var price: String? = ""
    ) : InvoiceUIState()

    data class Success(var invoice: Invoice) : InvoiceUIState()
    data class ResError(var errId: Int) : InvoiceUIState()
    data class TextError(var err: String) : InvoiceUIState()


}