package com.example.myapplication.data.model.response

data class GeneralResponse(
    val success: Boolean,
    val message: String,
    val data: Any,
)
