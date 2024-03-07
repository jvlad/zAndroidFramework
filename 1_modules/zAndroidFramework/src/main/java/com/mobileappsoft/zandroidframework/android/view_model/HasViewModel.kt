package com.mobileappsoft.zandroidframework.android.view_model

import androidx.lifecycle.ViewModel

interface HasViewModel<T: ViewModel> {

    val viewModel: Lazy<T>
}