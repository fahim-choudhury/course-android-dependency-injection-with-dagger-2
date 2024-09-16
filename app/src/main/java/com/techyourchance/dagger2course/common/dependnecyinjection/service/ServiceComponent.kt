package com.techyourchance.dagger2course.common.dependnecyinjection.service

import android.content.Context
import com.techyourchance.dagger2course.screens.common.service.MyService
import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent(modules = [ServiceModule::class])
interface ServiceComponent {
    fun inject(target: MyService)

    @Subcomponent.Builder
    interface Builder {
        @BindsInstance fun context(context: Context): Builder
        fun serviceModule(serviceModule: ServiceModule): Builder
        fun build(): ServiceComponent
    }
}