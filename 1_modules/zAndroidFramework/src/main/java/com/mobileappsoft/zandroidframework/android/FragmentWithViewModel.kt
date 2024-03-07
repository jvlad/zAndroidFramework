package com.mobileappsoft.zandroidframework.android

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel

abstract class FragmentWithViewModel<T: ViewModel>: Fragment() {

    protected abstract fun mainViewModel(): T

}