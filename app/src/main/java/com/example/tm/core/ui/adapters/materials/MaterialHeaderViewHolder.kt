package com.example.tm.core.ui.adapters.materials

import androidx.recyclerview.widget.RecyclerView
import com.example.tm.R
import com.example.tm.core.ui.adapters.Bind
import com.example.tm.databinding.MaterialItemBinding
import com.example.tm.domain.model.Material

class MaterialViewHolder(private val materialItemBinding: MaterialItemBinding) :
    RecyclerView.ViewHolder(materialItemBinding.root) ,Bind<Material>{
    private val meterUnit = materialItemBinding.root.context.getString(R.string.m)
    override fun bind(model: Material) {
        materialItemBinding.apply {
        model.apply {
            tvMaterialName.text = name
            tvCompanyName.text = company
            tvOneKiloInMaters.text = buildString {
                append(kilogram)
                append(" ")
                append(meterUnit)
            }

        }
        }
    }


}