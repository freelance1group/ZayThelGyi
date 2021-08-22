package com.example.zaythelgyi.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.example.zaythelgyi.R
import com.example.zaythelgyi.mvp.presenter.ConfirmPasswordPresenterImpl
import com.example.zaythelgyi.mvp.view.ConfirmPasswordView
import com.hanks.passcodeview.PasscodeView

class ConfirmPasswordActivity : BaseActivity() , ConfirmPasswordView{

    private lateinit var mPresenter : ConfirmPasswordPresenterImpl
    private lateinit var passcodeVew : PasscodeView
    private lateinit var from : String

    companion object {
        private const val FROM = "from"
        fun newIntent(context: Context, password: String): Intent {
            val intent = Intent(context, ConfirmPasswordActivity::class.java)
            intent.putExtra(FROM, password)
            return intent
        }
    }

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
        from = intent.getStringExtra(FROM).toString()
    }

    override fun listener() {
        passcodeVew = findViewById(R.id.passcodeview_confirm)
        val confirmPassword = passcodeVew.localPasscode

        if(confirmPassword == from){
            startActivity(ToStartAddingActivity.newIntent(this))
        }
    }
}