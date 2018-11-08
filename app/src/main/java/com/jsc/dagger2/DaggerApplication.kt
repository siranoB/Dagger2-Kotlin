package com.jsc.dagger2

import android.app.Activity
import android.app.Service
import android.content.BroadcastReceiver
import android.support.multidex.MultiDexApplication
import com.jsc.dagger2.dagger.DaggerAppComponent
import dagger.android.*
import javax.inject.Inject

class DaggerApplication : MultiDexApplication(), HasActivityInjector, HasServiceInjector,
        HasBroadcastReceiverInjector {
    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    @Inject
    lateinit var serviceDispatchingAndroidInjector: DispatchingAndroidInjector<Service>

    @Inject
    lateinit var broadcastReceiverInjector: DispatchingAndroidInjector<BroadcastReceiver>

    override fun activityInjector(): AndroidInjector<Activity> = activityDispatchingAndroidInjector

    override fun serviceInjector(): AndroidInjector<Service> = serviceDispatchingAndroidInjector

    override fun broadcastReceiverInjector(): AndroidInjector<BroadcastReceiver> = broadcastReceiverInjector

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder().application(this).build().inject(this)
    }
}