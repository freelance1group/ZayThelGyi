package com.example.zaythelgyi.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.zaythelgyi.R
import com.example.zaythelgyi.activity.ChooseCategoryActivity
import com.example.zaythelgyi.adapter.ProductAdapter
import com.example.zaythelgyi.data.vos.ProductVo
import com.example.zaythelgyi.mvp.presenter.ProductFragmentPresenterImpl
import com.example.zaythelgyi.mvp.view.ProductFragmentView
import kotlinx.android.synthetic.main.activity_choose_category.*
import kotlinx.android.synthetic.main.fragment_product_list.*

class ProductFragment : BaseFragment(), ProductFragmentView {

    private lateinit var mPresenter : ProductFragmentPresenterImpl
    private lateinit var productAdapter : ProductAdapter
    private lateinit var productList : MutableList<ProductVo>

    companion object {
        fun newFragment() : Fragment {
            return ProductFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_product_list,container,false)
        setUpPresenter()
        mPresenter.onCreateView()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mPresenter.onViewCreated()
    }

    private fun setUpPresenter() {
        mPresenter = ProductFragmentPresenterImpl()
        mPresenter.initPresenter(this)
    }

    override fun init() {
        productList = ArrayList()
    }

    override fun listener() {
        fab_product.setOnClickListener {
            startActivity(ChooseCategoryActivity.newIntent(requireContext()))
        }
    }

    override fun setUpProductAdapter() {
        productAdapter = ProductAdapter(requireContext())
        val lm = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
        rv_product_list.layoutManager = lm
        rv_product_list.adapter = productAdapter

        productList.add(ProductVo(getString(R.string.start_category_name), getString(R.string.category_name), getString(R.string.category_count), getString(R.string.category_count)))
        productList.add(ProductVo(getString(R.string.start_category_name), getString(R.string.category_name), getString(R.string.category_count), getString(R.string.category_count)))
        productList.add(ProductVo(getString(R.string.start_category_name), getString(R.string.category_name), getString(R.string.category_count), getString(R.string.category_count)))
        productList.add(ProductVo(getString(R.string.start_category_name), getString(R.string.category_name), getString(R.string.category_count), getString(R.string.category_count)))

        productAdapter.bindCategory(productList)
    }
}