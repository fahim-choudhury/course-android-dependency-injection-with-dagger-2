package com.techyourchance.dagger2course.screens.common.service

import android.content.Intent
import android.os.IBinder
import com.techyourchance.dagger2course.questions.FetchQuestionDetailsUseCase
import com.techyourchance.dagger2course.questions.FetchQuestionsUseCase
import javax.inject.Inject

class MyService : BaseService() {

    @Inject lateinit var fetchQuestionsUseCase: FetchQuestionsUseCase
    @Inject lateinit var fetchQuestionDetailsUseCase: FetchQuestionDetailsUseCase

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        serviceComponent.inject(this)
    }
}