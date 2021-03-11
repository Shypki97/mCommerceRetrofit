package com.e.mcommerceretrofit.service


import android.util.Log
import com.e.mcommerceretrofit.model.Commerce
import com.facebook.stetho.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


private const val TAG = "CommerceListService"

/**
 * On appelle ici le service de liste des ingrédients. Une liste des ingrédients est passée dans
 * le cas d'un succès alors qu'un message est propagé en cas d'erreur
 */
fun requestCommerce(
    service: CommerceListService,
    onSuccess: (commerce: List<Commerce>) -> Unit,
    onError: (error: String) ->Unit) {

    service.getCommerce().enqueue(
        object : Callback<List<Commerce>> {
            override fun onFailure(call: Call<List<Commerce>>, t: Throwable) {
                Log.e(TAG, "fail to get data", t)
                onError(t.message ?: "unknown error")
            }

            override fun onResponse(
                call: Call<List<Commerce>>,
                response: Response<List<Commerce>>
            ) {
                Log.d(TAG, "got a response $response")
                if (response.isSuccessful){
                    val commerce = response.body() ?: emptyList()
                    onSuccess(commerce)
                }else {
                    onError(response.errorBody()?.string() ?: "Unknown error")
                }
            }
        }
    )

}

interface CommerceListService{
    /**
     * On effectue un appel "GET" sur l'URL
     */
    @GET("android-hiring-test/products.json")
    fun getCommerce(): Call<List<Commerce>>
    companion object{
        private const val BASE_URL = "https://agf.ikomobi.fr/"
        fun create(): CommerceListService{
            val logger = HttpLoggingInterceptor()
            logger.level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BASIC else HttpLoggingInterceptor.Level.NONE

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CommerceListService::class.java)
        }
    }

}