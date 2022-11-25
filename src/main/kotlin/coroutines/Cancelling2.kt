package coroutines

import coroutines.utils.Utils
import kotlinx.coroutines.*

fun main() {
    Utils().startProgramMessage(Thread.currentThread().name)

    runBlocking {
        var sum = 0

        val job: Job = launch(Dispatchers.Default) {
            for (i in 1..100) {
                // if the coroutine has finished its work, break out of the loop
                if (!isActive){
                    // returns to the launch level when the coroutine's operations are finished
                    return@launch // break
                }
                sum += i
                print("$i, ")
            }
        }

        delay(10)

        job.cancelAndJoin()

        println("\n\n${Thread.currentThread().name}: sum = $sum")
    }

    Utils().endProgramMessage(Thread.currentThread().name)
}