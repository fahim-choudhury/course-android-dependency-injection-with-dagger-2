package com.techyourchance.dagger2course.screens.common.activities

import androidx.appcompat.app.AppCompatActivity
import com.techyourchance.dagger2course.MyApplication
import com.techyourchance.dagger2course.common.dependnecyinjection.ActivityModule
import com.techyourchance.dagger2course.common.dependnecyinjection.DaggerActivityComponent
import com.techyourchance.dagger2course.common.dependnecyinjection.DaggerPresentationComponent
import com.techyourchance.dagger2course.common.dependnecyinjection.Injector
import com.techyourchance.dagger2course.common.dependnecyinjection.PresentationModule

open class BaseActivity: AppCompatActivity() {

    val activityComponent by lazy {
        DaggerActivityComponent.builder()
            .activityModule(ActivityModule(this, (application as MyApplication).appComponent))
            .build()
    }

    private val presentationComponent by lazy {
        DaggerPresentationComponent.builder()
            .presentationModule(PresentationModule(activityComponent))
                .build()
    }

    protected val injector get() = Injector(presentationComponent)
}