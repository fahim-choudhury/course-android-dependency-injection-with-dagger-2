package com.techyourchance.dagger2course.common.dependnecyinjection.app

import android.app.Application
import com.techyourchance.dagger2course.Constants
import com.techyourchance.dagger2course.common.dependnecyinjection.Production
import com.techyourchance.dagger2course.common.dependnecyinjection.Staging
import com.techyourchance.dagger2course.networking.StackoverflowApi
import com.techyourchance.dagger2course.questions.FetchQuestionDetailsUseCase
import com.techyourchance.dagger2course.questions.FetchQuestionsUseCase
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class AppModule(val application: Application) {

    @Provides
    @AppScope
    fun application() = application

    companion object {
        @Provides
        @AppScope
        @Staging
        fun retrofitStaging(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        @Provides
        @AppScope
        @Production
        fun retrofitProduction(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        @Provides
        @AppScope
        fun stackoverflowApi(@Staging retrofit: Retrofit): StackoverflowApi {
            return retrofit.create(StackoverflowApi::class.java)
        }

        @Provides
        @AppScope
        fun fetchQuestionsUseCase(stackoverflowApi: StackoverflowApi) =
            FetchQuestionsUseCase(stackoverflowApi)

        @Provides
        @AppScope
        fun fetchQuestionDetailsUseCase(stackoverflowApi: StackoverflowApi) =
            FetchQuestionDetailsUseCase(stackoverflowApi)
    }
}