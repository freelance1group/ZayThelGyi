package com.example.zaythelgyi.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.zaythelgyi.data.vos.ProductVo
import kotlinx.android.synthetic.main.adapter_product_list_fragment.view.*

class ProductViewHolder(view: View): RecyclerView.ViewHolder(view){
    fun bindProduct(productVo: ProductVo) {
        itemView.tv_start_product_name.text = productVo.start_product_name
        itemView.tv_product_name.text = productVo.product_name
        itemView.tv_quantity.text = productVo.product_quantity
        itemView.tv_price.text = productVo.product_price


    }

}
