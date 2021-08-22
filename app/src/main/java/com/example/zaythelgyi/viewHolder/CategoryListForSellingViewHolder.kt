package com.example.zaythelgyi.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.zaythelgyi.activity.StartSellingActivity
import com.example.zaythelgyi.data.vos.CategoryVo
import com.example.zaythelgyi.fragment.CategoryFragment
import kotlinx.android.synthetic.main.adapter_category_list_for_selling.view.*

class CategoryListForSellingViewHolder(
    view: View,
    startSellingActivity: StartSellingActivity
) : RecyclerView.ViewHolder(view) {
    fun bindCategory(categoryVo: CategoryVo) {
        itemView.tv_category_name_selling.text = categoryVo.category_name
        itemView.tv_category_price_selling.text = categoryVo.category_count
    }

    init {
        itemView.iv_record_for_selling.setOnClickListener {
            startSellingActivity.recordForSellingCategory(adapterPosition)

        }

    }

}
