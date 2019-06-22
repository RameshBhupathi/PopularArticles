package io.ramesh.populararticles.di.modules

import dagger.Module
import dagger.Provides
import io.ramesh.populararticles.BuildConfig
import io.ramesh.populararticles.data.remote.ApiService
import io.ramesh.populararticles.data.remote.HeaderInterceptor
import io.ramesh.populararticles.util.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


/**
 * Created by Ramesh Bhupathi on 2019-06-22.
 */

@Module
class NetWorkModule {

    @Provides
    @Singleton
    fun provideOkHttpClinet(): OkHttpClient {

        val httpClientBuilder = OkHttpClient.Builder()

        if (BuildConfig.DEBUG)
            httpClientBuilder.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))

        httpClientBuilder.addInterceptor(HeaderInterceptor())

        return httpClientBuilder.build()
    }


    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {

        val retrofitBuilder = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())

        return retrofitBuilder.build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {

        return retrofit.create(ApiService::class.java)
    }

}