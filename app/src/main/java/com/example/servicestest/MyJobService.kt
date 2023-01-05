package com.example.servicestest

import android.app.job.JobParameters
import android.app.job.JobService
import android.util.Log
import kotlinx.coroutines.*

class MyJobService : JobService() {

    private val scope = CoroutineScope(Dispatchers.Main)

    override fun onCreate() {
        super.onCreate()
        log("onCreate")
    }

    override fun onStartJob(params: JobParameters?): Boolean {
        log("onStartCommand")
        scope.launch {
            for (i in 0 until 100) {
                delay(1000)
                log("Timer: $i")
            }
        }
        return true
    }

    override fun onStopJob(params: JobParameters?): Boolean {
        TODO("Not yet implemented")
    }

    override fun onDestroy() {
        super.onDestroy()
        log("onDestroy")
        scope.cancel()
    }

    private fun log(message: String) {
        Log.d("SERVICE_TAG", "MyService: $message")
    }
}
