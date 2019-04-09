package com.cxyzy.demo

import android.app.IntentService
import android.content.Intent

class SampleService : IntentService("download_worker_thread") {
    private val tag = SampleService::class.java.simpleName
    override fun onHandleIntent(intent: Intent?) {
        log(tag, "onNewIntent")
        doSomething()
    }

    private fun doSomething() {
        log(tag, "doSomething")
        Thread.sleep(2000)
    }

    override fun onCreate() {
        log(tag, "onCreate")
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        log(tag, "onStartCommand")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        log(tag, "onDestroy")
        super.onDestroy()
    }
}