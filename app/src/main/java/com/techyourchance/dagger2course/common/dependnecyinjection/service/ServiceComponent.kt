package com.techyourchance.dagger2course.common.dependnecyinjection.service

import com.techyourchance.dagger2course.screens.common.service.MyService
import dagger.Subcomponent

@Subcomponent(modules = [ServiceModule::class])
interface ServiceComponent {
    fun inject(target: MyService)
}