package com.kslim.album_kotlin.ui.splash

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.kslim.album_kotlin.BR
import com.kslim.album_kotlin.R
import com.kslim.album_kotlin.ViewModelProviderFactory
import com.kslim.album_kotlin.databinding.ActivitySplashBinding
import com.kslim.album_kotlin.ui.base.BaseActivity

class SplashActivity : BaseActivity<ActivitySplashBinding, SplashViewModel>() {

    private lateinit var mProviderFactory: ViewModelProviderFactory
    private lateinit var mSplashViewModel: SplashViewModel

    override fun getLayoutId(): Int {
        return R.layout.activity_splash
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getViewModel(): SplashViewModel {
        mProviderFactory = ViewModelProviderFactory()
        mSplashViewModel =
            ViewModelProvider(this, mProviderFactory).get(SplashViewModel::class.java)
        return mSplashViewModel
    }

}
