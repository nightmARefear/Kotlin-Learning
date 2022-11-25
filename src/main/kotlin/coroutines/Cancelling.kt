package coroutines

import coroutines.utils.Utils
import kotlinx.coroutines.*

fun main() {
    Utils().startProgramMessage(Thread.currentThread().name)

    runBlocking {
        var sum = 0

        val job: Job = launch {
            for (i in 1..100) {
                sum += i
                print("$i, ")
                //Thread.sleep(50L)
                delay(500) // delays the printing of each value by half a second
            }
        }

        delay(5000) // delays the coroutine execution for 5 seconds

//        job.cancel()
//        job.join()
        // we can use instead:
        job.cancelAndJoin()

        println("\n\n${Thread.currentThread().name}: sum = $sum")
    }

    Utils().endProgramMessage(Thread.currentThread().name)
}