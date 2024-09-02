package com.techyourchance.dagger2course.screens.common.activities

import androidx.appcompat.app.AppCompatActivity
import com.techyourchance.dagger2course.MyApplication
import com.techyourchance.dagger2course.common.dependnecyinjection.activity.ActivityModule
import com.techyourchance.dagger2course.common.dependnecyinjection.activity.DaggerActivityComponent
import com.techyourchance.dagger2course.common.dependnecyinjection.presentation.PresentationModule

open class BaseActivity: AppCompatActivity() {

    val activityComponent by lazy {
        DaggerActivityComponent.builder()
            .appComponent((application as MyApplication).appComponent)
            .activityModule(ActivityModule(this))
            .build()
    }

    private val presentationComponent by lazy {
        activityComponent.newPresentationComponent(PresentationModule())
    }

    protected val injector get() = presentationComponent
}