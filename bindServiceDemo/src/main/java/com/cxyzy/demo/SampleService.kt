package com.cxyzy.demo

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import kotlin.random.Random


class SampleService : Service() {
    private val tag = SampleService::class.java.simpleName

    inner class MyBinder : Binder() {

        val service: SampleService
            get() = this@SampleService
    }

    private val binder = MyBinder()

    private fun doSomething() {
        log(tag, "doSomething")
        Thread.sleep(2000)
    }

    override fun onBind(intent: Intent?): IBinder? {
        log(tag, "onBind")
        doSomething()
        return binder
    }

    override fun onUnbind(intent: Intent?): Boolean {
        log(tag, "onUnbind")
        return false
    }


    override fun onDestroy() {
        log(tag, "onDestroy")
        super.onDestroy()
    }

    fun getRandomNumber(): Int {
        return Random.nextInt()
    }

}