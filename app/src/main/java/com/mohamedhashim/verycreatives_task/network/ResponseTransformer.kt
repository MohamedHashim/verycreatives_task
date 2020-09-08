package com.mohamedhashim.verycreatives_task.network

import com.mohamedhashim.verycreatives_task.ApiResponse
import retrofit2.Call
import retrofit2.Callback

/**
 * Created by Mohamed Hashim on 9/7/2020.
 */
fun <T> Call<T>.transform(onResult: (response: ApiResponse<T>) -> Unit) {
    enqueue(object : Callback<T> {
        override fun onResponse(call: Call<T>, response: retrofit2.Response<T>) {
            onResult(ApiResponse.of { response })
        }

        override fun onFailure(call: Call<T>, throwable: Throwable) {
            onResult(ApiResponse.error(throwable))
        }
    })
}

fun <T> ApiResponse.Failure.Error<T>.message() = "$code: ${responseBody?.string()}"

fun <T> ApiResponse.Failure.Exception<T>.message() = "$message"
