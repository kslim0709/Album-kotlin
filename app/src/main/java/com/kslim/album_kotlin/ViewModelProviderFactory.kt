package com.kslim.album_kotlin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kslim.album_kotlin.ui.main.MainViewModel
import java.lang.IllegalArgumentException

class ViewModelProviderFactory : ViewModelProvider.Factory {


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class: " + modelClass.name)
    }
}