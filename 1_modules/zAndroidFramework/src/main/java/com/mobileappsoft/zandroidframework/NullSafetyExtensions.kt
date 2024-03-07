package com.mobileappsoft.zandroidframework

fun <T> T.ifNullThen(altValue: T): T {
    return this ?: altValue
}

fun <T> checkNotNull(reference: T?): T {
    if (reference == null) {
        throw NullPointerException()
    }
    return reference
}

