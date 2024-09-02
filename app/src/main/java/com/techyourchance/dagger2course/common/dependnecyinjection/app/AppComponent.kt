package com.techyourchance.dagger2course.common.dependnecyinjection.app

import com.techyourchance.dagger2course.common.dependnecyinjection.activity.ActivityComponent
import com.techyourchance.dagger2course.common.dependnecyinjection.activity.ActivityModule
import dagger.Component

@Component(modules = [AppModule::class])
@AppScope
interface AppComponent {
    fun newActivityComponent(activityModule: ActivityModule): ActivityComponent
}