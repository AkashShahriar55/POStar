package com.cookietech.postar.Data.Worker

import android.content.Context
import android.util.Log
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import androidx.test.platform.app.InstrumentationRegistry
import androidx.work.Configuration
import androidx.work.ListenableWorker
import androidx.work.WorkManager
import androidx.work.testing.SynchronousExecutor
import androidx.work.testing.TestListenableWorkerBuilder
import androidx.work.testing.WorkManagerTestInitHelper
import androidx.work.workDataOf
import com.cookietech.postar.UNIT_DATA_FILENAME
import org.hamcrest.CoreMatchers
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


//https://developer.android.com/topic/libraries/architecture/workmanager/how-to/integration-testing
@RunWith(AndroidJUnit4::class)
@SmallTest
class PrepopulateDbWorkerTest {

    private lateinit var context:Context
    private lateinit var workManager:WorkManager

    @Before
    fun setup(){


        context = InstrumentationRegistry.getInstrumentation().targetContext

        // Configure WorkManager
        val config = Configuration.Builder()
            // Set log level to Log.DEBUG to make it easier to debug
            .setMinimumLoggingLevel(Log.DEBUG)
            // Use a SynchronousExecutor here to make it easier to write tests
            .setExecutor(SynchronousExecutor())
            .build()

        // Initialize WorkManager for instrumentation tests.
        WorkManagerTestInitHelper.initializeTestWorkManager(context,config)

        workManager = WorkManager.getInstance(context)

    }

    @Test
    fun testRefreshMainDataWork() {
        // Get the ListenableWorker
        val worker = TestListenableWorkerBuilder<PrepopulateDbWorker>(
            context = context,
            inputData = workDataOf(PrepopulateDbWorker.KEY_FILENAME to UNIT_DATA_FILENAME)
        ).build()

        // Start the work synchronously
        val result = worker.startWork().get()

        Assert.assertThat(result, CoreMatchers.`is`(ListenableWorker.Result.success()))



    }
}