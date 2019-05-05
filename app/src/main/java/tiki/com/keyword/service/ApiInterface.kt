package tiki.com.keyword.service

import io.reactivex.Observable
import retrofit2.http.GET

interface ApiInterface {
    @GET("tikivn/android-home-test/v2/keywords.json")
    fun getKeyword(): Observable<List<String>>
}
