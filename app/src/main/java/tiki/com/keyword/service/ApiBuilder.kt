package tiki.com.keyword.service

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiBuilder() {
    companion object {
        fun create(): ApiInterface {
            val retrofit = Retrofit.Builder().baseUrl("https://raw.githubusercontent.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
            return retrofit.create(ApiInterface::class.java)
        }
    }
}
