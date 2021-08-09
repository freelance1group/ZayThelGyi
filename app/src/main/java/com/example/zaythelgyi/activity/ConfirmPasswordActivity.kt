package com.example.zaythelgyi.activity

import android.os.Bundle
import com.example.zaythelgyi.R
import com.example.zaythelgyi.mvp.presenter.ConfirmPasswordPresenterImpl
import com.example.zaythelgyi.mvp.view.ConfirmPasswordView

class ConfirmPasswordActivity : BaseActivity() , ConfirmPasswordView{

    private lateinit var mPresenter : ConfirmPasswordPresenterImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        setContentView(R.layout.activity_confirm_password)
        setUpPresenter()
        mPresenter.onCreate()
    }

    private fun setUpPresenter() {
        mPresenter = ConfirmPasswordPresenterImpl()
        mPresenter.initPresenter(this)
    }

    override fun init() {
        TODO("Not yet implemented")
    }

    override fun listener() {
        TODO("Not yet implemented")
    }
}