package com.techyourchance.dagger2course.common.dependnecyinjection.app

import com.techyourchance.dagger2course.common.dependnecyinjection.activity.ActivityComponent
import com.techyourchance.dagger2course.common.dependnecyinjection.service.ServiceComponent
import com.techyourchance.dagger2course.common.dependnecyinjection.service.ServiceModule
import dagger.Component

@Component(modules = [AppModule::class])
@AppScope
interface AppComponent {
    fun newActivityComponentBuilder(): ActivityComponent.Builder
    fun newServiceComponentBuilder(): ServiceComponent.Builder
}