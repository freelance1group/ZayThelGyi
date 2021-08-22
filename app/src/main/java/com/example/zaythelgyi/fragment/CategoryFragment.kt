package com.example.zaythelgyi.fragment

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.PopupMenu
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.zaythelgyi.R
import com.example.zaythelgyi.adapter.CategoryAdapter
import com.example.zaythelgyi.data.vos.CategoryVo
import com.example.zaythelgyi.database.AppDB
import com.example.zaythelgyi.database.CategoryDAO
import com.example.zaythelgyi.database.CategoryEntity
import com.example.zaythelgyi.delegate.AddingCategoryPopupDelegate
import com.example.zaythelgyi.mvp.presenter.CategoryFragmentPresenterImpl
import com.example.zaythelgyi.mvp.view.CategoryFragmentView
import com.orhanobut.dialogplus.DialogPlus
import com.orhanobut.dialogplus.ViewHolder
import kotlinx.android.synthetic.main.activity_start_selling.*
import kotlinx.android.synthetic.main.fragment_category_list.*

class CategoryFragment : BaseFragment(), CategoryFragmentView, AddingCategoryPopupDelegate {

    private lateinit var mPresenter : CategoryFragmentPresenterImpl
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var categoryList: MutableList<CategoryVo>

    private var db: AppDB? = null
    private var dao: CategoryDAO? = null

    companion object {
        fun newFragment(): Fragment {
            return CategoryFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_category_list,container,false)
        setUpPresenter()
        mPresenter.onCreateView()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mPresenter.onViewCreated()
    }

    private fun setUpPresenter() {
        mPresenter = CategoryFragmentPresenterImpl()
        mPresenter.initPresenter(this)
    }


    override fun init() {
        categoryList = ArrayList()

        //access database
        db = AppDB.getAppDB(requireContext())
        dao = db!!.categoryDao()
    }

    override fun listener() {


        fab_category.setOnClickListener {
            showDialog()
        }
    }

    private fun showDialog() {
        val dialog = DialogPlus.newDialog(requireContext())
            .setContentHolder(ViewHolder(R.layout.create_new_category))
            .setGravity(Gravity.TOP)
            .setMargin(0,0,0,300)
            .setContentBackgroundResource(android.R.color.transparent)
            .create()
        val btn_save = dialog.findViewById(R.id.btn_new_category_save) as Button
        val newCategoryName = dialog.findViewById(R.id.et_new_category_name) as EditText

        btn_save.setOnClickListener {
            val categoryName = newCategoryName.text.toString()
            val thread = Thread{
                var categoryEntity = CategoryEntity()
                categoryEntity.categoryName = categoryName.toString()


                db!!.categoryDao().saveCategory(categoryEntity)
                db!!.categoryDao().getAllCategory(categoryEntity.categoryName).forEach(){
                    Log.d("database","getCategory $it")
                    //categoryList.add(CategoryVo(it.categoryName,it.categoryId.toString()))
                }
            }
            thread.start()
            dialog.dismiss()
        }
        dialog.show()
    }

    override fun setUpCategoryAdapter() {
        categoryAdapter = CategoryAdapter(requireContext(), this)
        val lm = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
        rv_category_list.layoutManager = lm
        rv_category_list.adapter = categoryAdapter

        categoryList.add(CategoryVo(getString(R.string.start_category_name), getString(R.string.category_name), getString(R.string.category_count)))
        categoryList.add(CategoryVo(getString(R.string.start_category_name), getString(R.string.category_name), getString(R.string.category_count)))
        categoryList.add(CategoryVo(getString(R.string.start_category_name), getString(R.string.category_name), getString(R.string.category_count)))
        categoryList.add(CategoryVo(getString(R.string.start_category_name), getString(R.string.category_name), getString(R.string.category_count)))

        categoryAdapter.bindCategory(categoryList)
    }

    override fun addingCategoryPopUp(po: Int) {
        Log.d("position", "addingCategory $po")
        val popMenu = PopupMenu(requireContext(), btn_pop_up)
        popMenu.menuInflater.inflate(R.menu.pop_menu_for_category_frag, popMenu.menu)
        popMenu.show()
    }
}