package com.mobileappsoft.zandroidframework.android

import android.content.Context

data class StringResource(private val id: Int,
                          private val args: Array<String> = emptyArray()) {

    // allows to ignore value of `args` property
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as StringResource

        if (id != other.id) return false

        return true
    }

    // allows to ignore value of `args` property
    override fun hashCode(): Int {
        return id
    }

    fun value(context: Context): String = if (args.isEmpty()) context.getString(id)
                                            else context.getString(id, *args)
}