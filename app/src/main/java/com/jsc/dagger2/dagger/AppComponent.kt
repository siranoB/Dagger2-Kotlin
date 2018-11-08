package com.jsc.dagger2.dagger

import android.app.Application
import com.jsc.dagger2.dagger.module.ActivityBuilder
import com.jsc.dagger2.dagger.module.AppModule
import com.jsc.dagger2.dagger.module.ReceiverBuilder
import com.jsc.dagger2.dagger.module.ServiceBuilder
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import com.jsc.dagger2.DaggerApplication
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class,
    AppModule::class, ActivityBuilder::class, ServiceBuilder::class, ReceiverBuilder::class])
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }


    fun inject(app: DaggerApplication)
}