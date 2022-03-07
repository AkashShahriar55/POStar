package com.cookietech.postar.Data.Worker

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters


/***
 * https://developer.android.com/topic/libraries/architecture/workmanager?gclid=Cj0KCQiA95aRBhCsARIsAC2xvfw6l8Zey2I_GTa7u6bEew-f8wQicYFNjkkJqWiroT_-x3TzsYTQavIaAj5PEALw_wcB&gclsrc=aw.ds
 * three types of persistent work
 * Immediate - begin immediately and complete soon :  and
 *          Expedited -
 * Long Running - Run for longer ( 10min+) : WorkRequest and Worker
 *          setForeground() : for handle notification
 * Deferrable - scheduled task for later and periodic : PeriodicWorkRequest and Worker
 *
 * other benefits:
 *      Work constraints - Define when to run the task
 *      Robust scheduling - schedule unique ,replaceable work , monitor and cancel groups of work.
 *                          scheduled works are managed in SQLite database and WorkManager takes care of
 *                          persists and rescheduling . Power saving features like Doze mode
 *      Expedited Work - Expedited work for important tasks to complete within few minutes
 *      Flexible retry policy - offers flexible retry policy including configurable exponential backoff
 *                              policy
 *      Work chaining - chain individual work tasks together that which run sequentially and which run
 *                      parallel
 *      Build-in threading interoperability - Sync with Coroutines and RxJava
 */





class PrepopulateDbWorker(
    context: Context,
    params: WorkerParameters
): CoroutineWorker(context,params) {
    override suspend fun doWork(): Result {
        return Result.success()
    }


    companion object {
        private const val TAG = "PrepopulateDbWorker"
        const val KEY_FILENAME = "UNIT_DATA_FILENAME"
    }
}