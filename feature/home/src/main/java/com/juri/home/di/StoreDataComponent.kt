package com.juri.home.di

import android.content.Context
import com.juri.core.di.CoreComponent
import com.juri.home.presentation.HomeFragment
import dagger.BindsInstance
import dagger.Component
import dagger.hilt.android.EntryPointAccessors

@Component(
    dependencies = [CoreComponent::class]
)
interface StoreDataComponent {
    @Component.Builder
    interface Builder {
        fun create(@BindsInstance context: Context): Builder
        fun appDependencies(coreComponent: CoreComponent): Builder
        fun build(): StoreDataComponent
    }

    fun inject(homeFragment: HomeFragment)
}

internal fun HomeFragment.inject() {
    DaggerStoreDataComponent.builder()
        .create(requireContext())
        .appDependencies(
            EntryPointAccessors.fromApplication(
                this.requireContext().applicationContext,
                CoreComponent::class.java
            )
        )
        .build()
        .inject(this)
}

