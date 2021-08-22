package com.example.zaythelgyi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.zaythelgyi.R
import com.example.zaythelgyi.data.vos.CategoryVo
import com.example.zaythelgyi.fragment.CategoryFragment
import com.example.zaythelgyi.viewHolder.CategoryViewHolder

class CategoryAdapter(private val context: Context, private val categoryFragment: CategoryFragment) :
    RecyclerView.Adapter<CategoryViewHolder>() {

    private var category_list: ArrayList<CategoryVo> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.adapter_category_list_fragment, parent, false)
        return CategoryViewHolder(view, categoryFragment)
    }

    override fun getItemCount(): Int {
        return category_list.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bindCategory(category_list[position])
    }

    fun bindCategory(categoryList: MutableList<CategoryVo>) {
        category_list = categoryList as ArrayList<CategoryVo>
    }


}
