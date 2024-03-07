package com.mobileappsoft.zandroidframework.android.logger

private const val kotlinCallerStackTraceIndex = 6

/**
 * To output extensive information about where log comes from this function uses
 * Thread.stackTrace internally.
 * To work properly with default value of `stackTraceEntryIndex` parameter
 * the call to this private function should be 2 stack_frames deeper than
 * the outer_caller – the caller that originally wants to put something to log.

 * That is, each function [that calls this private function] needs to be accessible
 * from outside (be public) and call this function directly, without forwarding to any
 * other function that uses this private function. So the call_stack should look like this:
 *
 * function that needs to put something to log
 * |-> mediator log function (which is public) (see examples below: logDebug(..), logInfo(...))
 *     |-> this function
 *
 * In case you want to use it with more forwardings, be sure to increment default
 * `stackTraceEntryIndex` for each forwarding.
 *
 */
fun log(message: String,
                tag: String = "",
                logFunc: ((t: String, m: String) -> Int) = ZLog::d,
                stackTraceEntryIndex: Int = kotlinCallerStackTraceIndex
) {
    val detailedTag = detailedTag(stackTraceEntryIndex, tag)
    logFunc(detailedTag, message)
}

fun detailedTag(stackTraceEntryIndex: Int, tagPrefix: String): String {
    val stackTraceEntry = Thread.currentThread().stackTrace[stackTraceEntryIndex]
    val fileName = stackTraceEntry.fileName
    val methodName = stackTraceEntry.methodName
    val lineNumber = stackTraceEntry.lineNumber
    val fullPrefix = "${if (tagPrefix.isNotEmpty()) "$tagPrefix " else ""}($fileName:$lineNumber) $methodName()"
    return fullPrefix
}

/**
 * Do not change signature of this method. It's been introduced for compatibility with
 * existing Java code.
 * I. e. to be able to easily change calls like `Log.d(TAG, "message")` to logDebug(TAG, "message")
 * */
fun logDebug(tag: String, message: String) {
    log(message = message, tag = tag)
}

fun logDebug(message: String) {
    log(message = message, tag = "")
}

fun logDebugEnteredMethod(tag: String) {
    log(message = "Entered", tag = tag)
}


/**
 * Do not change signature of this method. It's been introduced for compatibility with
 * existing Java code.
 * I. e. to be able to easily change calls like `Log.i(TAG, "message")` to logInfo(TAG, "message")
 * */
fun logInfo(tag: String, message: String) {
    log(message = message, tag = tag, logFunc = ZLog::i)
}

fun logInfo(message: String) {
    log(message = message, tag = "", logFunc = ZLog::i)
}


/**
 * Do not change signature of this method. It's been introduced for compatibility with
 * existing Java code.
 * I. e. to be able to easily change calls like `Log.w(TAG, "message")` to logWarning(TAG, "message")
 * */
fun logWarning(tag: String, message: String) {
    log(message = message, tag = tag, logFunc = ZLog::w)
}

fun logWarning(message: String) {
    log(message = message, tag = "", logFunc = ZLog::w)
}


/**
 * Do not change signature of this method. It's been introduced for compatibility with
 * existing Java code.
 * I. e. to be able to easily change calls like `Log.e(TAG, "message")` to logError(TAG, "message")
 * */
fun logError(tag: String, message: String) {
    log(message = message, tag = tag, logFunc = ZLog::e)
}

fun logErrorWithDefaultMessage(tag: String) {
    log(message = "Error occurred", tag = tag, logFunc = ZLog::e)
}

fun logError(message: String) {
    log(message = message, tag = "", logFunc = ZLog::e)
}

