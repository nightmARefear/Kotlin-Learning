package coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    println("${Thread.currentThread().name}: main program starts")
    printTopMainSeparators()

    var sum = 0

    val job: Job = launch {
        println("${Thread.currentThread().name}: start of work")
        for (i in 1..100) sum += i
        println("${Thread.currentThread().name}: end of work")
    }

    job.join()

    println("${Thread.currentThread().name}: sum = $sum")

    printBottomMainSeparators()
    println("${Thread.currentThread().name}: main program ends")
}

private fun printTopMainSeparators() {
    println("----------------------------------------\n")
}

private fun printBottomMainSeparators() {
    println("\n----------------------------------------")
}