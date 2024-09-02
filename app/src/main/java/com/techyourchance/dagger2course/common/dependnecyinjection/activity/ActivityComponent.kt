package com.techyourchance.dagger2course.common.dependnecyinjection.activity

import com.techyourchance.dagger2course.common.dependnecyinjection.app.AppComponent
import com.techyourchance.dagger2course.common.dependnecyinjection.presentation.PresentationComponent
import com.techyourchance.dagger2course.common.dependnecyinjection.presentation.PresentationModule
import dagger.Component

@Component(dependencies = [AppComponent::class], modules = [ActivityModule::class])
@ActivityScope
interface ActivityComponent {
    fun newPresentationComponent(presentationModule: PresentationModule): PresentationComponent
}