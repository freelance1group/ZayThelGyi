package com.example.zaythelgyi.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.zaythelgyi.R
import com.example.zaythelgyi.mvp.presenter.AboutShopPresenterImpl
import com.example.zaythelgyi.mvp.view.AboutShopView
import kotlinx.android.synthetic.main.activity_about_shop.*

class AboutShopActivity : BaseActivity(), AboutShopView{

    private lateinit var mPresenter : AboutShopPresenterImpl

    companion object {
        fun newIntent(context : Context): Intent {
            val intent = Intent(context, AboutShopActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        setContentView(R.layout.activity_about_shop)
        setUpPresenter()
        mPresenter.onCreate()
    }

    private fun setUpPresenter() {
        mPresenter = AboutShopPresenterImpl()
        mPresenter.initPresenter(this)
    }

    override fun init() {
        listener()
    }

    override fun listener() {
        btn_continue.setOnClickListener{
            startActivity(ToStartAddingActivity.newIntent(this))
        }
    }
}