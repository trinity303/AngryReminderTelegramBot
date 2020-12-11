package bot

import java.util.concurrent.Future
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit

class ScheduledReminder(
    var executor: ScheduledExecutorService,
    var future: Future<*>? = null
) {

    fun changeExecutor(
        runnable: Runnable,
        period: Long
    ) {
        future = executor.scheduleAtFixedRate(runnable, period, period, TimeUnit.SECONDS)
    }
}