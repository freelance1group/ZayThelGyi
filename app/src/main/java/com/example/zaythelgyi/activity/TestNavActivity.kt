package com.example.zaythelgyi.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.zaythelgyi.R
import com.example.zaythelgyi.mvp.presenter.MainPresenterImpl
import com.example.zaythelgyi.mvp.view.MainView

class TestNavActivity: BaseActivity(), MainView {

    private lateinit var mPresenter : MainPresenterImpl

    companion object {
        fun newIntent(context: Context): Intent {
            val intent = Intent(context, TestNavActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpPresenter()
        mPresenter.onCreate()
    }

    private fun setUpPresenter() {
        mPresenter = MainPresenterImpl()
        mPresenter.initPresenter(this)
    }

    override fun init() {
        TODO("Not yet implemented")
    }

    override fun listener() {
        TODO("Not yet implemented")
    }
}