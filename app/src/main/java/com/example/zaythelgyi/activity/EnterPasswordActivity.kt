package com.example.zaythelgyi.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.zaythelgyi.R
import com.example.zaythelgyi.mvp.presenter.EnterPasswordPresenterImpl
import com.example.zaythelgyi.mvp.view.EnterPasswordView

class EnterPasswordActivity : BaseActivity() , EnterPasswordView {

    private lateinit var mPresenter : EnterPasswordPresenterImpl

    companion object {
        fun newIntent(context: Context) : Intent {
            val intent = Intent(context, EnterPasswordActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        setContentView(R.layout.activity_enter_password)
        setUpPresenter()
        mPresenter.onCreate()
    }

    private fun setUpPresenter() {
        mPresenter = EnterPasswordPresenterImpl()
        mPresenter.initPresenter(this)
    }


    override fun init() {
        listener()
    }

    override fun listener() {
        //startActivity(ToStartAddingActivity.newIntent(this))
    }
}