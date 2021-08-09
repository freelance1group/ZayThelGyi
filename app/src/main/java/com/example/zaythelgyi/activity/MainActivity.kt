package com.example.zaythelgyi.activity

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import com.example.zaythelgyi.R
import com.example.zaythelgyi.mvp.presenter.MainPresenterImpl
import com.example.zaythelgyi.mvp.view.MainView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : BaseActivity(), MainView {

    private lateinit var mPresenter : MainPresenterImpl

    companion object {
        fun newIntent(context: Context): Intent {
            val intent = Intent(context, MainActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        setContentView(R.layout.activity_main)
        setUpPresenter()
        mPresenter.onCreate()
        setUpDrawer()
    }

    @SuppressLint("RestrictedApi")
    private fun setUpDrawer() {
        val toggle = ActionBarDrawerToggle(
            this,
            drawer_layout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)

        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true);
            supportActionBar!!.setDefaultDisplayHomeAsUpEnabled(false);
            toggle.isDrawerIndicatorEnabled = false;
            toggle.setHomeAsUpIndicator(R.drawable.drawer_icon);
        }
        toggle.syncState();
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