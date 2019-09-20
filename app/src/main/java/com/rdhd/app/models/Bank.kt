package com.rdhd.app.models

data class BankCard(
    val cardnumber : String? = null,
    val password : String? = null,
    val cv2 : String? = null,
    val month : Int = 0,
    val year : Int = 0,
    val phonenumber : String? = null,
    var checked : Boolean = false
)