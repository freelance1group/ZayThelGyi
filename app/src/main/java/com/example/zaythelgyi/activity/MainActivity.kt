package com.example.zaythelgyi.activity

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.zaythelgyi.R
import com.example.zaythelgyi.fragment.CategoryFragment
import com.example.zaythelgyi.fragment.ProductFragment
import com.example.zaythelgyi.mvp.presenter.MainPresenterImpl
import com.example.zaythelgyi.mvp.view.MainView
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : BaseActivity(), MainView, NavigationView.OnNavigationItemSelectedListener {

    private lateinit var mPresenter : MainPresenterImpl

    companion object {
        fun newIntent(context: Context): Intent {
            val intent = Intent(context, MainActivity::class.java)
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
            toggle.isDrawerIndicatorEnabled = true;
            toggle.setHomeAsUpIndicator(R.drawable.drawer_icon);
        }

        toggle.syncState();
        nav_view.setNavigationItemSelectedListener(this)
    }

    private fun setUpPresenter() {
        mPresenter = MainPresenterImpl()
        mPresenter.initPresenter(this)
    }

    override fun init() {
    }

    override fun listener() {
        fab.setOnClickListener {
            startActivity(StartSellingActivity.newIntent(this))
        }
    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        Log.d("menu", p0.title as String)
        val menuItem = p0.title.toString()
        Log.d(
            "menu", "menuItem $menuItem"
        )
        when(menuItem) {
            "Sellinig Lists" -> {

                loadFragment(CategoryFragment.newFragment())
            }
            "Catogories" -> {
                fab.hide()
                loadFragment(CategoryFragment.newFragment())
            }
            "Products" -> {
                fab.hide()
                loadFragment(ProductFragment.newFragment())
            }
        }


        return true
    }

    private fun loadFragment(fragment: Fragment) {
        Log.d("fragment","Fragment")
        drawer_layout.closeDrawer(GravityCompat.START)
        supportFragmentManager.beginTransaction().replace(R.id.frame, fragment).commit()
    }
}