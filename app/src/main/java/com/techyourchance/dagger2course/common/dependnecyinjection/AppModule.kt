package com.techyourchance.dagger2course.common.dependnecyinjection

import android.app.Application
import com.techyourchance.dagger2course.Constants
import com.techyourchance.dagger2course.networking.StackoverflowApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class AppModule(val application: Application) {

    @Provides
    fun application() = application

    @Provides
    fun retrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    @Provides
    fun stackoverflowApi(retrofit: Retrofit): StackoverflowApi {
        return retrofit.create(StackoverflowApi::class.java)
    }

}