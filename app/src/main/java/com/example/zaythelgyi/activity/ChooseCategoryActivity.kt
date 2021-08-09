package com.example.zaythelgyi.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.zaythelgyi.R
import com.example.zaythelgyi.adapter.ChooseCategoryAdapter
import com.example.zaythelgyi.data.vos.CategoryVo
import com.example.zaythelgyi.mvp.presenter.ChooseCategoryPresenterImpl
import com.example.zaythelgyi.mvp.view.ChooseCateegoryView
import kotlinx.android.synthetic.main.activity_choose_category.*

class ChooseCategoryActivity : BaseActivity(), ChooseCateegoryView {

    private lateinit var mPresenter : ChooseCategoryPresenterImpl
    private lateinit var categoryAdapter : ChooseCategoryAdapter
    private lateinit var categoryList: MutableList<CategoryVo>

    companion object {
        fun newIntent(context: Context): Intent {
            val intent = Intent(context, ChooseCategoryActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        setContentView(R.layout.activity_choose_category)
        setUpPresenter()
        mPresenter.onCreate()
    }

    private fun setUpPresenter() {
        mPresenter = ChooseCategoryPresenterImpl()
        mPresenter.initPresenter(this)
    }

    override fun init() {
        categoryList = ArrayList()
    }

    override fun listener() {
        //setUpCategoryAdapter()
    }

    override fun setUpCategoryAdapter() {
        categoryAdapter = ChooseCategoryAdapter(this)
        val lm = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        rv_to_choose_category.layoutManager = lm
        rv_to_choose_category.adapter = categoryAdapter

        categoryList.add(CategoryVo(getString(R.string.start_category_name), getString(R.string.category_name), getString(R.string.category_count)))
        categoryList.add(CategoryVo(getString(R.string.start_category_name), getString(R.string.category_name), getString(R.string.category_count)))
        categoryList.add(CategoryVo(getString(R.string.start_category_name), getString(R.string.category_name), getString(R.string.category_count)))
        categoryList.add(CategoryVo(getString(R.string.start_category_name), getString(R.string.category_name), getString(R.string.category_count)))

        categoryAdapter.bindCategory(categoryList)

    }
}