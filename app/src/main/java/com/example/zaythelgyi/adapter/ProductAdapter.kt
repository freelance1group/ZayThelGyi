package com.example.zaythelgyi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.zaythelgyi.R
import com.example.zaythelgyi.data.vos.ProductVo
import com.example.zaythelgyi.viewHolder.ProductViewHolder

class ProductAdapter(private val context: Context) :
    RecyclerView.Adapter<ProductViewHolder>() {

    private var product_list: ArrayList<ProductVo> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.adapter_product_list_fragment, parent, false)
        return ProductViewHolder(view)
    }

    override fun getItemCount(): Int {
        return product_list.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bindProduct(product_list[position])
    }

    fun bindCategory(productList: MutableList<ProductVo>) {
        product_list = productList as ArrayList<ProductVo>
    }

}
