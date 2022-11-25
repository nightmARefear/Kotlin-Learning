package coroutines

import coroutines.utils.Utils
import kotlinx.coroutines.*

fun main() {
    Utils().startProgramMessage(Thread.currentThread().name)

    runBlocking {
        var sum = 0

        val job: Job = launch(Dispatchers.Default) {
            try {
                for (i in 1..100) {
                    sum += i
                    print("$i, ")
                    delay(5)
                }
                //    it is triggered because the launch coroutine is suspended
            } catch (e: CancellationException) {
                println("\nException caught safely: ${e.message}")
            } finally {
                withContext(NonCancellable) {
                    delay(10)
                    println("\nFinally executed!")
                }
            }
        }

        delay(10)

        job.cancelAndJoin()

        println("\n\n${Thread.currentThread().name}: sum = $sum")
    }

    Utils().endProgramMessage(Thread.currentThread().name)
}