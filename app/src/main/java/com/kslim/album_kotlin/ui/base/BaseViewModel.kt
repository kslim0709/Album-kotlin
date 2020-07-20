package com.kslim.album_kotlin.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel() {

    private val mCompositeDisposable = CompositeDisposable()
    val mIsLoading = MutableLiveData<Boolean>(false)

    override fun onCleared() {
        mCompositeDisposable.dispose()
        super.onCleared()
    }

    fun addDisposable(disposable: CompositeDisposable) {
        mCompositeDisposable.add(disposable)
    }


}