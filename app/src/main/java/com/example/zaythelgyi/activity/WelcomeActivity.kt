package com.example.zaythelgyi.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.zaythelgyi.R
import com.example.zaythelgyi.mvp.presenter.WelcomePresenterImpl
import com.example.zaythelgyi.mvp.view.WelcomeView
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : BaseActivity() , WelcomeView {

    private lateinit var mPresenter : WelcomePresenterImpl

    companion object {
        fun newIntent(context: Context): Intent {
            val intent = Intent(context, WelcomeActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        requestWindowFeature(Window.FEATURE_NO_TITLE)
//        window.setFlags(
//            WindowManager.LayoutParams.FLAG_FULLSCREEN,
//            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        this.supportActionBar?.hide()
        setContentView(R.layout.activity_welcome)
        setUpPresenter()
        mPresenter.onCreate()
    }

    private fun setUpPresenter() {
        mPresenter = WelcomePresenterImpl()
        mPresenter.initPresenter(this)
    }

    override fun init() {
        listener()
    }

    override fun listener() {
        btn_start_use.setOnClickListener {
            startActivity(AboutShopActivity.newIntent(this))
        }
    }
}