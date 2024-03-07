package com.mobileappsoft.zandroidframework

interface BackStackOwner {
    fun goBack()
    fun setBackStackListenerParent(listener: ChildBackStackListener)
}


interface ChildBackStackListener {
    fun onChildBackStackIsEmpty(backStackOwner: BackStackOwner)
}
