package com.techyourchance.dagger2course.screens.common.activities

import androidx.appcompat.app.AppCompatActivity
import com.techyourchance.dagger2course.MyApplication

open class BaseActivity: AppCompatActivity() {

    val activityComponent by lazy {
        (application as MyApplication).appComponent.newActivityComponentBuilder()
            .activity(this)
            .build()
    }

    private val presentationComponent by lazy {
        activityComponent.newPresentationComponent()
    }

    protected val injector get() = presentationComponent
}