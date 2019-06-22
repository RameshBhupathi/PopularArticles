package io.ramesh.populararticles.di

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass


/**
 * Created by Ramesh Bhupathi on 2019-06-22.
 */
@MapKey
@Target(AnnotationTarget.FUNCTION)
internal annotation class ViewModelKey(val value: KClass<out ViewModel>)
