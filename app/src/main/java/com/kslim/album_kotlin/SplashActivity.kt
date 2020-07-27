package com.kslim.album_kotlin

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kslim.album_kotlin.ui.main.MainActivity
import com.kslim.album_kotlin.utils.Permission

class SplashActivity : AppCompatActivity() {

    private lateinit var mPermission: Permission


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        permissionCheck()
    }

    private fun permissionCheck() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            mPermission = Permission(applicationContext, this@SplashActivity);

            if (!mPermission.checkPermission()) {
                mPermission.requesetPermission()
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<out String>, grantResults: IntArray
    ) {
        if (!mPermission.permissionResult(requestCode, permissions, grantResults)) {
            mPermission.requesetPermission()
        } else {
            val startIntent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(startIntent)
            finish()
        }
    }
}
