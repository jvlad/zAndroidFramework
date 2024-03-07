package com.mobileappsoft.zandroidframework.android.logger

import android.util.Log

object ZLog {
    fun d(t: String, m: String): Int {
        return Log.d(t, m)
    }

    fun i(t: String, m: String): Int {
        return Log.i(t, m)
    }

    fun w(t: String, m: String): Int {
        return Log.w(t, m)
    }

    fun e(t: String, m: String): Int {
        return Log.e(t, m)
    }
}