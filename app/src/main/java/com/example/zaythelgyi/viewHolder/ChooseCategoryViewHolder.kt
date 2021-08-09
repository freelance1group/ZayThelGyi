package com.example.zaythelgyi.viewHolder

import android.content.Intent
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.zaythelgyi.activity.PriceQauntityForCategoryActivity
import com.example.zaythelgyi.activity.WelcomeActivity
import com.example.zaythelgyi.data.vos.CategoryVo
import kotlinx.android.synthetic.main.activity_price_quantity_for_category.view.*
import kotlinx.android.synthetic.main.adapter_category_list.view.*

class ChooseCategoryViewHolder(view : View) : RecyclerView.ViewHolder(view) {

    fun bindCategory(categoryList: CategoryVo) {
        Log.d("category", categoryList.start_category_name)
        Log.d("category", categoryList.category_name)
        Log.d("category", categoryList.category_count.toString())
        itemView.tv_start_category_name.text = categoryList.start_category_name
        itemView.tv_category_name.text = categoryList.category_name
        itemView.tv_category_count.text = categoryList.category_count.toString()
    }

    init {
        itemView.cl_category_main.setOnClickListener {
                itemView.context.startActivity(
                    Intent(itemView.context, PriceQauntityForCategoryActivity::class.java)
                )
        }
    }

}
