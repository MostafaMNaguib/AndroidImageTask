package com.example.myapplication.utils

import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService


object AppUtils {

    fun toast(context: Context, msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }
    fun isInternetAvailable(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        Log.e("AppUtil", "isInternetAvailable: " )

        return (cm.activeNetworkInfo != null && cm.activeNetworkInfo!!.isConnected)
    }

    fun isNetworkAvailable(context: Context): String {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
//        Log.e("AppUtils", "isNetworkAvailable: ${connectivityManager.activeNetworkInfo!!}" )
        return if(connectivityManager.activeNetworkInfo != null && connectivityManager.activeNetworkInfo!!.isConnected)
        {
            if (connectivityManager.activeNetworkInfo!!.typeName.contains("WIFI"))
                "WIFI"
            else
                connectivityManager.activeNetworkInfo!!.typeName
        }else{
            "Not Connected"
        }
    }

}