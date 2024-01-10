package com.example.myapplication.base

import android.accounts.NetworkErrorException
import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.model.response.GeneralResponse
import com.example.myapplication.utils.AppUtils.isInternetAvailable
import com.example.myapplication.utils.Constants
import com.example.myapplication.utils.NetworkState

import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
open class BaseViewModel @Inject constructor() :
    ViewModel() {

    fun <T> runApi(
        _apiStateFlow: MutableStateFlow<NetworkState>,
        block: Response<T>, context: Context
    ) {

        Log.e(TAG, "runApi: 0611")
        try {
            if (isInternetAvailable(context)) {
                Log.e(TAG, "runApi: 06")

                runCatching {
                    block
                }.onFailure {

                    Log.e(TAG, "runApi: 3 ${it.localizedMessage[0]}")
                    when (it) {
                        is java.net.UnknownHostException ->
                            _apiStateFlow.value =
                                NetworkState.Error(Constants.Codes.EXCEPTIONS_CODE)
                        is java.net.ConnectException ->
                            _apiStateFlow.value =
                                NetworkState.Error(Constants.Codes.EXCEPTIONS_CODE)
                        is NetworkErrorException ->
                            _apiStateFlow.value =
                                NetworkState.Error(Constants.Codes.BAD_REQUEST,it.message)
                        else -> _apiStateFlow.value =
                            NetworkState.Error(Constants.Codes.UNKNOWN_CODE)
                    }

                }.onSuccess {

                    Log.e(TAG, "runApi: 4")
                    if (it.body() != null)
                        _apiStateFlow.value = NetworkState.Result(it.body())
                    else {
                        val errorResponse = Gson().fromJson(it.errorBody()!!.charStream(), GeneralResponse::class.java)

                        Log.e(TAG, "runApi: ${(it.message())} ${it.headers()} === ${it.errorBody()!!.charStream()} ")
                        Log.e(TAG, "runApi:5435 ${errorResponse.message} " )
                        _apiStateFlow.value = NetworkState.Error(400 ,errorResponse.message)
                    }
                }

            } else {
                Log.e(TAG, "runApi: 05")
                _apiStateFlow.value = NetworkState.Error(Constants.Codes.EXCEPTIONS_CODE)
            }
        } catch (e: Exception) {
            Log.e(TAG, "runApi: ${(e as NetworkErrorException).message}")
        }


    }

    companion object {
        private const val TAG = "BaseViewModel"
    }

}