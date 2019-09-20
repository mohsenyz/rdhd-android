package com.rdhd.app.utils

import java.util.regex.Pattern

private val persianNumbers = arrayOf("۰", "۱", "۲", "۳", "۴", "۵", "۶", "۷", "۸", "۹")

fun String.fa() : String {
    if (this.length == 0) {
        return ""
    }
    var length = this.length
    var out = ""
    for (i in 0..(length - 1)) {
        var c = this[i]
        if ('0' <= c && c <= '9') {
            var number = Integer.parseInt(c.toString())
            out += persianNumbers[number]
        } else if (c == '٫') {
            out += '،'
        } else {
            out += c
        }
    }
    return out
}

fun String.normalizePhone() : String? {
    try {
        val pattern = Pattern.compile("(\\+98|98|0098|0)?(9[0-9]{9})")
        val matcher = pattern.matcher(this)
        if (matcher.find()) {
            return matcher.group(2)
        }
    } catch (ex : Throwable) {
        ex.printStackTrace()
    }
    return null
}