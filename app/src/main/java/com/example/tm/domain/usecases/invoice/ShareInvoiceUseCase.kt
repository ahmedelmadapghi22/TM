package com.example.tm.domain.usecases.invoice

import com.example.tm.R
import com.example.tm.domain.model.Invoice
import com.example.tm.domain.usecases.Preconditions
import com.example.tm.domain.usecases.UseCaseResult
import javax.inject.Inject

class CreateInvoiceUseCase @Inject constructor() {

    operator fun invoke(
        customerName: String,
        materialName: String,
        totalMeters: String,
        totalWeight: String,
        price: String,
    ): UseCaseResult {
        if (Preconditions.checkFiled(customerName)) {
            return UseCaseResult.ResourceError(R.string.err_customer_name)
        } else if (Preconditions.checkFiled(materialName)) {
            return UseCaseResult.ResourceError(R.string.err_material_name)
        } else if (Preconditions.checkFiled(totalMeters)) {
            return UseCaseResult.ResourceError(R.string.err_total_meters)
        } else if (Preconditions.checkFiled(totalWeight)) {
            return UseCaseResult.ResourceError(R.string.err_total_weight)
        } else if (Preconditions.checkFiled(price)) {
            return UseCaseResult.ResourceError(R.string.err_pirce)
        } else {
            return UseCaseResult.Success(
                Invoice(
                    customerName,
                    materialName,
                    totalMeters,
                    totalWeight,
                    price
                )
            )

        }


    }
}