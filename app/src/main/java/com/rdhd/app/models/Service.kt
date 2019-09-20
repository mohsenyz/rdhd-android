package com.rdhd.app.models

data class Service (
    val serviceName : String,
    val serviceIcon : Int
)


data class GetService(
    val serviceName : String,
    val price : String,
    val period : String,
    val pricepp : String,
    val id : String,
    val startTime : Long,
    val endTime : Long
)