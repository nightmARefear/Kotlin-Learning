package coroutines

import coroutines.utils.Utils
import kotlinx.coroutines.*

fun main() = runBlocking{
    Utils().startProgramMessage(Thread.currentThread().name)

    // if the coroutine is not terminated within 2 seconds
    // then the TimeoutCancellationException is thrown
//    withTimeout(2000) {
//        try {
//            for (i in 1..200) {
//                print("$i,")
//                delay(100)
//            }
//        } catch (e : TimeoutCancellationException) {
//            println("Exception caught safely! ${e.message}")
//        }
//    }


    // no exception thrown
    var sum: Int? = 0
    sum = withTimeoutOrNull(2000) {
            for (i in 1..200) {
                print("$i,")
                sum = sum?.plus(i)
                delay(100)
            }
        sum
    }

    println("\n${Thread.currentThread().name}: sum = $sum")

    Utils().endProgramMessage(Thread.currentThread().name)
}