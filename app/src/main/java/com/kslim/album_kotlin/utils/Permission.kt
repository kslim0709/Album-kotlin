package com.kslim.album_kotlin.utils

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class Permission(context: Context, activity: Activity) {
    private var mContext: Context = context;
    private var mActivity: Activity = activity;

    private val MULTIPLE_PERMISSIONS: Int = 1023

    private lateinit var mPermissionList: ArrayList<String>

    private var mPermissions = arrayOf(
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE
    )

    public fun checkPermission(): Boolean {
        var result: Int
        mPermissionList = ArrayList()

        for (permission in mPermissions) {
            result = ContextCompat.checkSelfPermission(mContext, permission)
            when (result) {
                PackageManager.PERMISSION_DENIED -> mPermissionList.add(permission)
            }
        }

        if (mPermissionList.isNotEmpty())
            return false
        return true
    }

    fun requesetPermission() {
        ActivityCompat.requestPermissions(
            mActivity,
            mPermissionList.toArray(arrayOfNulls<String>(mPermissionList.size)),
            MULTIPLE_PERMISSIONS
        )
    }

    fun permissionResult(
        requesetCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ): Boolean {
        if (requesetCode == MULTIPLE_PERMISSIONS && grantResults.isNotEmpty()) {
            for (grant in grantResults) {
                when (grant) {
                    -1 -> return false
                }
            }
        }
        return true
    }

}