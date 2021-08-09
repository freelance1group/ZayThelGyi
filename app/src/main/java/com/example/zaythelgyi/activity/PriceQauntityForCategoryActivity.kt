package com.example.zaythelgyi.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.zaythelgyi.R
import com.example.zaythelgyi.mvp.presenter.PriceQuantityForCategoryPresenterImpl
import com.example.zaythelgyi.mvp.view.PriceQuantityForCategoryView
import kotlinx.android.synthetic.main.activity_price_quantity_for_category.*

class PriceQauntityForCategoryActivity : BaseActivity(), PriceQuantityForCategoryView {

    private lateinit var mPresenter : PriceQuantityForCategoryPresenterImpl

    companion object {
        fun newIntent(context: Context): Intent {
            val intent = Intent(context, PriceQauntityForCategoryActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        setContentView(R.layout.activity_price_quantity_for_category)
        setUpPresenter()
        mPresenter.onCreate()
    }

    private fun setUpPresenter() {
        mPresenter = PriceQuantityForCategoryPresenterImpl()
        mPresenter.initPresenter(this)
    }

    override fun init() {
    }

    override fun listener() {
        btn_continue_category.setOnClickListener{
            startActivity(ToStartSellingActivity.newIntent(this))
        }
    }
}