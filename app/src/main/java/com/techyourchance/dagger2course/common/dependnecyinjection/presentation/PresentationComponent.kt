package com.techyourchance.dagger2course.common.dependnecyinjection.presentation

import com.techyourchance.dagger2course.common.dependnecyinjection.activity.ActivityComponent
import com.techyourchance.dagger2course.screens.questiondetails.QuestionDetailsActivity
import com.techyourchance.dagger2course.screens.questionslist.QuestionsListFragment
import dagger.Component

@Component(dependencies = [ActivityComponent::class], modules = [PresentationModule::class])
@PresentationScope
interface PresentationComponent {
    fun inject(target: QuestionDetailsActivity)
    fun inject(target: QuestionsListFragment)

}