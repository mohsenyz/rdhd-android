package com.rdhd.app.models

data class Service (
    val serviceName : String,
    val serviceIcon : Int
)


data class GetService(
    val name : String? = null,
    val price : String? = null,
    val period : String? = null,
    val pricepp : String? = null,
    val id : String? = null,
    val col : String? = null,
    val phonenumber : String? = null,
    val idservice : String? = null,
    val starttime : Long = 0L,
    val endtime : Long = 0L,
    val barcode : String? = null
)