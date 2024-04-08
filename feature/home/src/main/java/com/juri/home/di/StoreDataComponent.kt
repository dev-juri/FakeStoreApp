package com.juri.home.di

import android.content.Context
import com.juri.core.di.CoreComponent
import com.juri.home.presentation.HomeFragment
import dagger.BindsInstance
import dagger.Component
import dagger.hilt.android.EntryPointAccessors

@Component(dependencies = [CoreComponent::class])
interface StoreDataComponent {

    fun inject(homeFragment: HomeFragment)

    @Component.Builder
    interface Builder {

        fun context(@BindsInstance context: Context): Builder

        fun appDependencies(coreComponent: CoreComponent): Builder

        fun build(): StoreDataComponent
    }
}

internal fun HomeFragment.inject() {
    DaggerStoreDataComponent.builder()
        .context(requireActivity().applicationContext)
        .appDependencies(
            EntryPointAccessors.fromApplication(
                requireActivity().applicationContext, CoreComponent::class.java
            )
        )
        .build()
        .inject(this)
}