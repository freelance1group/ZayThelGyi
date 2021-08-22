package com.example.zaythelgyi.viewHolder

import android.view.View
import android.widget.PopupMenu
import androidx.recyclerview.widget.RecyclerView
import com.example.zaythelgyi.R
import com.example.zaythelgyi.data.vos.CategoryVo
import com.example.zaythelgyi.fragment.CategoryFragment
import kotlinx.android.synthetic.main.activity_start_selling.*
import kotlinx.android.synthetic.main.adapter_category_list_fragment.view.*

class CategoryViewHolder(private val view: View, private val categoryFragment: CategoryFragment): RecyclerView.ViewHolder(view){
    fun bindCategory(categoryVo: CategoryVo) {
        itemView.tv_start_category_name_frag.text = categoryVo.start_category_name
        itemView.tv_category_name_frag.text = categoryVo.category_name
        itemView.tv_category_count_frag.text = categoryVo.category_count

    }

    init {
        itemView.iv_dot_category_fag.setOnClickListener {
                //categoryFragment.addingCategoryPopUp(adapterPosition)

            val popMenu = PopupMenu(itemView.context, itemView.iv_dot_category_fag)
            popMenu.menuInflater.inflate(R.menu.pop_menu_for_category_frag, popMenu.menu)
            popMenu.show()

        }
    }

}
