package com.techyourchance.dagger2course.screens.common.activities

import androidx.appcompat.app.AppCompatActivity
import com.techyourchance.dagger2course.MyApplication
import com.techyourchance.dagger2course.common.dependnecyinjection.activity.ActivityModule

open class BaseActivity: AppCompatActivity() {

    val activityComponent by lazy {
        (application as MyApplication).appComponent.newActivityComponentBuilder()
            .activity(this)
            .activityModule(ActivityModule)
            .build()
    }

    private val presentationComponent by lazy {
        activityComponent.newPresentationComponent()
    }

    protected val injector get() = presentationComponent
}