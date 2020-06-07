package br.com.baseapplication.data.api.config

import android.content.Context
import br.com.baseapplication.data.R
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ApiClient {

    inline fun <reified T> makeService(context: Context, moshi: Moshi): T {
        // TODO: add http logging to log request & response
        return retrofitCreate(
            context.getString(R.string.base_url),
            moshi
        )
    }

    inline fun <reified T> retrofitCreate(baseUrl: String, moshi: Moshi): T {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(MoshiConverterFactory.create(moshi).asLenient())
            .build()
        return retrofit.create(T::class.java)
    }
}
