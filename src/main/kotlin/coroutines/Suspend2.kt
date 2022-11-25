package coroutines

import kotlinx.coroutines.*

fun main() {
    println("${Thread.currentThread().name}: main program starts")
    printTopMainSeparators()

    var sum = 0
    runBlocking {


        val job: Job = launch {
            println("${Thread.currentThread().name}: start of work")
            for (i in 1..100) {
                sum += i
                print(i)
            }

            println("\nla")
            println("${Thread.currentThread().name}: end of work")
        }

        job.join()

        println("(0) ${Thread.currentThread().name}: sum = $sum")

    }

    println("(1) ${Thread.currentThread().name}: sum = $sum\n")

    val range = 1..200
    runBlocking {
        val jobDeferred: Deferred<Int> = async {
            var product = 1
            for (i in range) {
                print(i)
                product *= i
            }
            product
        }

        val product = jobDeferred.await()
        println("\n\n${Thread.currentThread().name}: product = $product")
    }

    printBottomMainSeparators()
    println("${Thread.currentThread().name}: main program ends")

}

private fun printTopMainSeparators() {
    println("----------------------------------------\n")
}

private fun printBottomMainSeparators() {
    println("\n----------------------------------------")
}