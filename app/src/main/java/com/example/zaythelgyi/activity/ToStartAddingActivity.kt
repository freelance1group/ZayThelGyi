package com.example.zaythelgyi.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.zaythelgyi.R
import com.example.zaythelgyi.mvp.presenter.ToStartAddingPresenterImpl
import com.example.zaythelgyi.mvp.view.ToStartAddingView
import kotlinx.android.synthetic.main.activity_to_start_adding.*

class ToStartAddingActivity : BaseActivity() , ToStartAddingView {

    private lateinit var mPresenter : ToStartAddingPresenterImpl

    companion object {
        fun newIntent(context: Context) : Intent {
            val intent = Intent(context, ToStartAddingActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        setContentView(R.layout.activity_to_start_adding)
        setUpPresenter()
        mPresenter.onCreate()

    }

    private fun setUpPresenter() {
        mPresenter = ToStartAddingPresenterImpl()
        mPresenter.initPresenter(this)
    }

    override fun init() {
       listener()
    }

    override fun listener() {
        btn_to_start_add.setOnClickListener{
            startActivity(ChooseCategoryActivity.newIntent(this))
        }
    }
}