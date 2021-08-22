package com.example.zaythelgyi.mvp.presenter

import com.example.zaythelgyi.mvp.view.CategoryFragmentView

class CategoryFragmentPresenterImpl : AbstractBasePresenter<CategoryFragmentView>(), CategoryFragmentPresenter {
    override fun onStart() {
        TODO("Not yet implemented")
    }

    override fun onCreate() {
        TODO("Not yet implemented")
    }

    override fun onCreateView() {
        mView?.init()

    }

    override fun onViewCreated() {
        mView?.listener()
        mView?.setUpCategoryAdapter()
    }

    override fun onResume() {
        TODO("Not yet implemented")
    }

    override fun onPause() {
        TODO("Not yet implemented")
    }

    override fun onStop() {
        TODO("Not yet implemented")
    }

    override fun onDestroy() {
        TODO("Not yet implemented")
    }
}