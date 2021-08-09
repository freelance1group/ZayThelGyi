package com.example.zaythelgyi.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.zaythelgyi.R
import com.example.zaythelgyi.mvp.presenter.ToStartSellingPresenterImpl
import com.example.zaythelgyi.mvp.view.ToStartSellingView
import kotlinx.android.synthetic.main.activity_to_start_selling.*

class ToStartSellingActivity : BaseActivity(), ToStartSellingView {

    private lateinit var mPresenter : ToStartSellingPresenterImpl

    companion object {
        fun newIntent(context: Context): Intent {
            val intent = Intent(context, ToStartSellingActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        setContentView(R.layout.activity_to_start_selling)
        setUpPresenter()
        mPresenter.onCreate()
    }

    private fun setUpPresenter() {
        mPresenter = ToStartSellingPresenterImpl()
        mPresenter.initPresenter(this)
    }

    override fun init() {
    }

    override fun listener() {
        btn_to_start_sell.setOnClickListener {
            startActivity(TestNavActivity.newIntent(this))
        }
    }
}