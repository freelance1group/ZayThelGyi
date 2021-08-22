package com.example.zaythelgyi.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.zaythelgyi.R
import com.example.zaythelgyi.database.AppDB
import com.example.zaythelgyi.database.CategoryDAO
import com.example.zaythelgyi.database.CategoryEntity
import com.example.zaythelgyi.mvp.presenter.PriceQuantityForCategoryPresenterImpl
import com.example.zaythelgyi.mvp.view.PriceQuantityForCategoryView
import kotlinx.android.synthetic.main.activity_price_quantity_for_category.*

class PriceQauntityForCategoryActivity : BaseActivity(), PriceQuantityForCategoryView {

    private lateinit var mPresenter : PriceQuantityForCategoryPresenterImpl
//    private var categoryName : String = ""
//    private var categoryPrice : Int = 0
//    private val categoryQuantity : Int = 0
    private var db: AppDB? = null
    private var dao: CategoryDAO? = null

    companion object {
        fun newIntent(context: Context): Intent {
            val intent = Intent(context, PriceQauntityForCategoryActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        setContentView(R.layout.activity_price_quantity_for_category)
        setUpPresenter()
        mPresenter.onCreate()
    }

    private fun setUpPresenter() {
        mPresenter = PriceQuantityForCategoryPresenterImpl()
        mPresenter.initPresenter(this)
    }

    override fun init() {

        //access database
        db = AppDB.getAppDB(this)
        dao = db!!.categoryDao()
    }

    override fun listener() {
        btn_continue_category.setOnClickListener{
            if(checkValidation())
            {
                saveData()
                startActivity(ToStartSellingActivity.newIntent(this))
            }

        }
    }

    private fun saveData() {
        val categoryName = et_category_name.text.toString()
        val categoryPrice = et_category_price.text
        val categoryQuantity = et_category_quantity.text

        //save
//        val thread = Thread {
//            var categoryEntity = CategoryEntity()
//            categoryEntity.categoryName = categoryName
//        }

    }

    private fun checkValidation(): Boolean {
        if(et_category_name.text.isEmpty()){
            et_category_name.error = R.string.error.toString()
        }
        else if(et_category_price.text.isEmpty()){
            et_category_price.error = R.string.error.toString()
        }
        else if(et_category_quantity.text.isEmpty()){
            et_category_quantity.error = R.string.error.toString()
        }

        return true
    }
}