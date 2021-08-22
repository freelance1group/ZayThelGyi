package com.example.zaythelgyi.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.example.zaythelgyi.R
import com.example.zaythelgyi.mvp.presenter.EnterPasswordPresenterImpl
import com.example.zaythelgyi.mvp.view.EnterPasswordView
import com.hanks.passcodeview.PasscodeView
import com.hanks.passcodeview.PasscodeView.PasscodeViewListener


class EnterPasswordActivity : BaseActivity() , EnterPasswordView {

    private lateinit var mPresenter : EnterPasswordPresenterImpl
    private lateinit var passcodeVew : PasscodeView
    private var password = ""

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
        passcodeVew = findViewById(R.id.passcodeviewenter)
        password = passcodeVew.localPasscode.toString()

    }

    override fun listener() {

        passcodeVew.setPasscodeLength(4) // to set pincode or passcode
//            .setLocalPasscode("12369") // to set listener to it to check whether
            // passwords has matched or failed
            .setListener(object : PasscodeViewListener {
                override fun onFail() {
                   Toast.makeText(this@EnterPasswordActivity, "Fail", Toast.LENGTH_LONG).show()
                }

                override fun onSuccess(number: String) {
                    startActivity(ConfirmPasswordActivity.newIntent(this@EnterPasswordActivity, password))
                }
            })


        //startActivity(ToStartAddingActivity.newIntent(this))
    }
}
