package com.cxyzy.demo

import android.app.Service
import android.content.Intent
import android.os.IBinder
import kotlin.concurrent.thread

class SampleService : Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    private val tag = SampleService::class.java.simpleName

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
        thread(name = "worker-thread") {
            doSomething()
        }
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        log(tag, "onDestroy")
        super.onDestroy()
    }
}