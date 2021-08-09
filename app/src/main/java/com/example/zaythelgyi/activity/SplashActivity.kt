package com.example.zaythelgyi.activity

import android.os.Bundle
import android.os.Handler
import com.example.zaythelgyi.R
import com.example.zaythelgyi.mvp.presenter.SplashPresenterImpl
import com.example.zaythelgyi.mvp.view.SplashView

class SplashActivity : BaseActivity() , SplashView {

    private lateinit var mPresenter : SplashPresenterImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        setContentView(R.layout.activity_splash)
        setUpPresenter()
        mPresenter.onCreate()

    }

    private fun setUpPresenter() {
        mPresenter = SplashPresenterImpl()
        mPresenter.initPresenter(this)
    }

    override fun init() {
        val handler = Handler()
        handler.postDelayed({
            startActivity(WelcomeActivity.newIntent(this))
        }, 1000
        )

    }

    override fun listener() {
        TODO("Not yet implemented")
    }
}