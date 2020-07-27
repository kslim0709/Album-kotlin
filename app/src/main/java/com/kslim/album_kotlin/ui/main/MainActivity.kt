package com.kslim.album_kotlin.ui.main

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.kslim.album_kotlin.BR
import com.kslim.album_kotlin.R
import com.kslim.album_kotlin.ViewModelProviderFactory
import com.kslim.album_kotlin.databinding.ActivityMainBinding
import com.kslim.album_kotlin.ui.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    private lateinit var mProviderFactory: ViewModelProviderFactory
    private lateinit var mMainViewModel: MainViewModel

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getViewModel(): MainViewModel {
        mProviderFactory = ViewModelProviderFactory()
        mMainViewModel =
            ViewModelProvider(this, mProviderFactory).get(MainViewModel::class.java)
        return mMainViewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}
