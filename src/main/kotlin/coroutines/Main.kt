package coroutines

import jdk.nashorn.internal.objects.Global
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.math.BigInteger
import kotlin.concurrent.thread


fun main() {
    // program #1

    /*
    println("\nMain program starts: ${Thread.currentThread().name}")
    //println("${Thread.getAllStackTraces().forEach { t, u -> println("\nt.id = ${t.id}, u.size = ${u.size}") }}")

    var sum = 0
    println("(before calculation) sum = $sum")

    // creates a worker thread
    thread {
        println("\ninside thread: ${Thread.currentThread().name}")
        for (i in 1..10000) sum += i
        //Thread.sleep(2000L)
        println("\nafter thread's work finishes: sum = $sum")
    }

    thread {
        println("\n${Thread.currentThread().name}----------------------------")
    }

    thread {
        for (i in 1..10) println("${Thread.currentThread().name}: $i")
    }

    thread {
        println("hi from thread ${Thread.currentThread().name}")
    }

    thread {
        println("${Thread.currentThread().name}: *************")
    }

    // waiting for other threads to finish, before displaying the result
    Thread.sleep(2000L)

    println("${Thread.currentThread().name}: sum = $sum")
    println("\nMain program ends: ${Thread.currentThread().name}")
    */



    // program 2
    /*
    println("\nMain program starts: ${Thread.currentThread().name}")

    var sum = 0
    println("(before calculation) sum = $sum")

    // creates a worker thread
    GlobalScope.launch {
        println("\ninside thread: ${Thread.currentThread().name}")
        for (i in 1..100) sum += i
        Thread.sleep(2000L)
        println("\n${Thread.currentThread().name}: " +
                "after thread's work finishes: sum = $sum")
    }

    GlobalScope.launch {
        println("\ninside thread: ${Thread.currentThread().name}")
        for (i in 1..10) println("$i")
    }

    Thread.sleep(2000L)
    println("${Thread.currentThread().name}: sum = $sum")
    println("\nMain program ends: ${Thread.currentThread().name}")
    */

    // program 3
    /*
    println("\n${Thread.currentThread().name}: main program starts")
    printMainSeparators()
    var sum = 0

    GlobalScope.launch {
        println("\n${Thread.currentThread().name} starts")
        for (i in 1..20000) sum += i
        //Thread.sleep(20L)
        println("\n${Thread.currentThread().name}: sum = $sum")

        GlobalScope.launch {
            printCoroutinesSeparators()
            println("hello from ${Thread.currentThread().name}")

            GlobalScope.launch {
                printCoroutinesSeparators()
                println("++++hello from ${Thread.currentThread().name}")
            }
            println("=-=-=-=-=-=")
        }

        //Thread.sleep(300L)
        println("\n${Thread.currentThread().name} ends")
    }

//
//    printCoroutinesSeparators()
//    GlobalScope.launch {
//        println("\n${Thread.currentThread().name} starts")
//        for (i in 1..20) sum += i
//        //Thread.sleep(20L)
//        println("\n${Thread.currentThread().name}: sum = $sum")
//        println("\n${Thread.currentThread().name} ends")
//    }
//    println("${Thread.currentThread().name}: sum = ${temp(10000, 100000)}")
    Thread.sleep(500L)
    println("\n----------------------------------------")
    println("${Thread.currentThread().name}: main program ends")

     */

    // program 4
    /*
    thread {
        println("(#0) hello from ${Thread.currentThread().name}")
    }

    thread {
        var sum = 0
        for (i in 1..1000000) sum += i
        Thread.sleep(500L)
        println("(#1) hello from ${Thread.currentThread().name}")
    }

    thread {
        var sum  = 0
        for (i in 1..1000000) sum += i
        println("(#2) hello from ${Thread.currentThread().name}")
    }

    thread {
        Thread.sleep(20)
        println("(#3) hello from ${Thread.currentThread().name}")
    }

     */

    // program 5
    /*
    var coroutineNumber = 0
    thread {
        GlobalScope.launch {
            println("(0) starts")
            println("(0) hello from coroutine #$coroutineNumber")
            println("(0) ends")
        }

        GlobalScope.launch {
        delay(10L)
            coroutineNumber++
            println("(1) hello from coroutine #$coroutineNumber")
        }

        GlobalScope.launch {
            coroutineNumber++
            println("(2) hello from coroutine #$coroutineNumber")
        }

        Thread.sleep(100L)
        // always (3) printed at the end, as the thread is blocked for 100 milliseconds
        GlobalScope.launch {
            coroutineNumber++
            println("(3) hello from coroutine #$coroutineNumber")
        }
    }
    Thread.sleep(500L)

     */

    // program 6
    /*
    GlobalScope.launch {
        println("start of coroutine in thread ${Thread.currentThread().name}")
        delay(1000L)
        println("end of coroutine in thread ${Thread.currentThread().name}")
    }

     */

    // program 7


    waitForThreadsToFinish(3000)
}

private fun printCoroutinesSeparators() {
    println("########################################")
}

private fun printMainSeparators() {
    println("----------------------------------------")
}

private fun temp(start: Int, end: Int):Int {
    var sum: Int = 0
    for (i in start..end ) sum += i

    return sum
}

/**
 * A bad way to wait for all the threads to finish, before stopping the program.
 */
private fun waitForThreadsToFinish(time: Long = 500L) {
    Thread.sleep(time)
}

