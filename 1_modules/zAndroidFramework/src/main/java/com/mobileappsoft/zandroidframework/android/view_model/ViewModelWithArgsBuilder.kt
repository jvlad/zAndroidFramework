package com.mobileappsoft.zandroidframework.android.view_model

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.*
import java.lang.IllegalArgumentException

class BaseViewModelFactory<T>(val creator: () -> T) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return creator() as T
    }
}

inline fun <reified T : ViewModel> Fragment.getViewModel(noinline creator: (() -> T)? = null): T {
    return getViewModel(this, creator)
}

inline fun <reified T : ViewModel> FragmentActivity.getViewModel(noinline creator: (() -> T)? = null): T {
    return getViewModel(this, creator)
}

inline fun <reified T: ViewModel> getViewModel(owner: ViewModelStoreOwner, noinline creator: (() -> T)? = null): T {
    return if (creator == null)
        when(owner) {
            is FragmentActivity -> ViewModelProviders.of(owner).get(T::class.java)
            is Fragment -> ViewModelProviders.of(owner).get(T::class.java)
            else -> throw IllegalArgumentException("Only FragmentActivity or Fragment are allowed")
        }
    else
        ViewModelProvider(owner, BaseViewModelFactory(creator)).get(T::class.java)
}