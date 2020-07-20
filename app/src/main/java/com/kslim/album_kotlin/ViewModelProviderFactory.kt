package com.kslim.album_kotlin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kslim.album_kotlin.ui.splash.SplashViewModel
import java.lang.IllegalArgumentException

class ViewModelProviderFactory : ViewModelProvider.Factory {


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(SplashViewModel::class.java)) {
            return SplashViewModel() as T // == new SplashViewModel() 와 같음
        }
        throw IllegalArgumentException("Unknown ViewModel Class: " + modelClass.name)
    }
}