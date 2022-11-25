package coroutines

import kotlinx.coroutines.*
import java.math.BigInteger

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

    val range = 1..100
    runBlocking {
        val jobDeferred: Deferred<BigInteger> = async {
            var product: BigInteger = BigInteger.valueOf(1L)
            for (i in range) {
                print(i)
                product *= BigInteger.valueOf(i.toLong())
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