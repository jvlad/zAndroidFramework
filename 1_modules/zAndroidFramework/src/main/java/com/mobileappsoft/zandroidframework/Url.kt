package com.mobileappsoft.zandroidframework

const val wwwPrefix = "www."
const val httpPrefix = "http"

inline class Url(val asString: String) {
    val isHttp
        get() = asString.startsWith(httpPrefix)
}