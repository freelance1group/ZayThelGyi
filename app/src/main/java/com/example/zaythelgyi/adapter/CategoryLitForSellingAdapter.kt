package com.example.zaythelgyi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.zaythelgyi.R
import com.example.zaythelgyi.activity.StartSellingActivity
import com.example.zaythelgyi.data.vos.CategoryVo
import com.example.zaythelgyi.fragment.CategoryFragment
import com.example.zaythelgyi.viewHolder.CategoryListForSellingViewHolder

class CategoryLitForSellingAdapter(private val context: Context, private val startSellingActivity: StartSellingActivity) :
    RecyclerView.Adapter<CategoryListForSellingViewHolder>() {

    private var category_list: ArrayList<CategoryVo> = ArrayList()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryListForSellingViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.adapter_category_list_for_selling, parent, false)
        return CategoryListForSellingViewHolder(view, startSellingActivity)
    }

    override fun getItemCount(): Int {
        return category_list.size
    }

    override fun onBindViewHolder(holder: CategoryListForSellingViewHolder, position: Int) {
        holder.bindCategory(category_list[position])
    }

    fun bindSellingCategory(categoryList: MutableList<CategoryVo>) {
        category_list = categoryList as ArrayList<CategoryVo>
    }


}
