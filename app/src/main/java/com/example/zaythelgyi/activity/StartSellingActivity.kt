package com.example.zaythelgyi.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.PopupMenu
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.zaythelgyi.R
import com.example.zaythelgyi.adapter.CategoryLitForSellingAdapter
import com.example.zaythelgyi.data.vos.CategoryVo
import com.example.zaythelgyi.delegate.RecordForSellingCategoryDelegate
import com.example.zaythelgyi.mvp.presenter.StartSellingPresenterImpl
import com.example.zaythelgyi.mvp.view.StartSellingView
import com.orhanobut.dialogplus.DialogPlus
import com.orhanobut.dialogplus.ViewHolder
import kotlinx.android.synthetic.main.activity_choose_category.*
import kotlinx.android.synthetic.main.activity_start_selling.*
import kotlinx.android.synthetic.main.activity_toolbar.*

class StartSellingActivity : BaseActivity(), StartSellingView, RecordForSellingCategoryDelegate {

    private lateinit var mPresenter : StartSellingPresenterImpl
    private lateinit var categoryListAdapter : CategoryLitForSellingAdapter
    private lateinit var categoryList: MutableList<CategoryVo>

    companion object {
        fun newIntent(context: Context): Intent {
            val intent = Intent(context, StartSellingActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        setContentView(R.layout.activity_start_selling)
        setUpPresenter()
        mPresenter.onCreate()
    }

    private fun setUpPresenter() {
        mPresenter = StartSellingPresenterImpl()
        mPresenter.initPresenter(this)
    }


    override fun init() {
        categoryList = ArrayList()
    }

    override fun listener() {
        btn_pop_up.setOnClickListener {
            val popMenu = PopupMenu(this, btn_pop_up)
            popMenu.menuInflater.inflate(R.menu.pop_menu, popMenu.menu)
            popMenu.show()
        }

        iv_toolbar_back.setOnClickListener {
            finish()
        }



    }

    override fun setUpCategoryForSellingAdapter() {
        categoryListAdapter = CategoryLitForSellingAdapter(this, this)
        val lm = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        rv_category_list_for_selling.layoutManager = lm
        rv_category_list_for_selling.adapter = categoryListAdapter

        categoryList.add(CategoryVo(getString(R.string.start_category_name), getString(R.string.category_name), getString(R.string.category_count)))
        categoryList.add(CategoryVo(getString(R.string.start_category_name), getString(R.string.category_name), getString(R.string.category_count)))
        categoryList.add(CategoryVo(getString(R.string.start_category_name), getString(R.string.category_name), getString(R.string.category_count)))
        categoryList.add(CategoryVo(getString(R.string.start_category_name), getString(R.string.category_name), getString(R.string.category_count)))

       categoryListAdapter.bindSellingCategory(categoryList)
    }

    override fun recordForSellingCategory(po: Int) {
        Log.d("position", po.toString())
        showDialog()
    }

    private fun showDialog() {
        val dialog = DialogPlus.newDialog(this)
            .setContentHolder(ViewHolder(R.layout.record_for_selling_category))
            .setGravity(Gravity.BOTTOM)
            .setMargin(0,300,0,0)
            .setContentBackgroundResource(android.R.color.transparent)
            .create()

        dialog.show()
    }
}