package com.example.tm.core.ui.adapters.goods

import androidx.recyclerview.widget.RecyclerView
import com.example.tm.R
import com.example.tm.core.ui.adapters.Bind
import com.example.tm.databinding.GoodsItemBinding
import com.example.tm.domain.model.Goods

class GoodsViewHolder(
    private val goodsItemBinding: GoodsItemBinding
) :
    RecyclerView.ViewHolder(goodsItemBinding.root), Bind<Goods> {
    private val context = goodsItemBinding.root.context
    override fun bind(model: Goods) {
        goodsItemBinding.apply {
            model.apply {
                tvGoodsDate.text = date
                tvGoodsName.text = materialName
                if (quantity.contains(context.getString(R.string.kg))) {
                    tvGoodsQuantity.text = buildString {
                        append(quantity)
                        append(" ")
                        append(context.getString(R.string.kg))
                    }

                } else {
                    tvGoodsQuantity.text = buildString {
                        append(quantity)
                        append(" ")
                        append(context.getString(R.string.m))
                    }
                }
                tvGoodsPrice.text = price

            }

        }
    }


}