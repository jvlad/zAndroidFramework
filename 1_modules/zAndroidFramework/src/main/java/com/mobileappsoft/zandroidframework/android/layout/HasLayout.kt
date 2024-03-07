package com.mobileappsoft.zandroidframework.android.layout

interface LayoutI {

    /**
     * @return ID of Android's layout resource (that is available via _R.layout_)
     */
    val layoutID: Int
}

interface HasLayout<T: LayoutI> {

    fun getContentViewResourceId(): Int
}
