package com.example.myapplication.utils

object Constants {

    const val BASE_URL = "http://alaimtidadsystem.3m-erp.com/api/"

    const val IS_LOGGED = "is_logged"


    object Codes {
        const val EXCEPTIONS_CODE = 3421
        const val API_KEY_CODE = 5020
        const val AUTH_CODE = 5000
        const val UNKNOWN_CODE = 560
        const val SUCCESSES_CODE = 1
        const val LOCATION_REQUEST_CODE = 23
        const val BAD_REQUEST = 400

    }

    object ShardKeys {

        const val SHARED_NAME = "AndroidTask"
        const val TOKEN = "token"
        const val EMAIL = "email"
        const val USER_ID = "id"
        const val PHOTO_URL = "photo_url"
        const val PHONE_NUMBER = "phone"
        const val NAME = "name"
        const val BALANCE = "balance"
        const val ROLE = "role"
        const val ROLE_STRING = "role_string"
        const val STATUS = "status"
        const val STATUS_STRING = "status_string"
        const val ACCESS_TOKEN = "access_token"
        const val LANG = "lang"
        const val AR = "ar"
        const val EN = "en"
        const val LATITUDE = "latitude"
        const val LONGITUDE = "longitude"

    }
    object ApisKeys {
        const val BEARER = "Bearer"
    }


}