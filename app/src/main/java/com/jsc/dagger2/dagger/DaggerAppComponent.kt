package com.jsc.dagger2.dagger

import android.app.Application
import com.jsc.dagger2.dagger.module.AppModule
import com.jsc.dagger2.DaggerApplication
import dagger.internal.Preconditions

class DaggerAppComponent(builder: Builder) : AppComponent {
    companion object {
        fun builder(): AppComponent.Builder {
            return Builder()
        }
    }

    init {
        initialize(builder)
    }


    private fun initialize(builde: Builder) {

    }

    private var appModule: AppModule? = null

    private var application: Application? = null

    override fun inject(app: DaggerApplication) {

    }

    class Builder : AppComponent.Builder {
        private var appModule: AppModule? = null

        private var application: Application? = null

        override fun build(): AppComponent {
            if (appModule == null) {
                this.appModule = AppModule()
            }
            if (application == null) {
                throw IllegalStateException(Application::class.java.canonicalName + " must be set")
            }
            return DaggerAppComponent(this)
        }

        override fun application(application: Application): Builder {
            this.application = Preconditions.checkNotNull(application)
            return this
        }
    }


}