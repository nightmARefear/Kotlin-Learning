package coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
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
        for (i in 1..10) println("${Thread.currentThread().name}: $i")
    }

    thread {
        println("hi from thread ${Thread.currentThread().name}")
    }

    println("\nMain program ends: ${Thread.currentThread().name}")
    println("${Thread.currentThread().name}: sum = $sum")
    */



    // program 2
    println("\nMain program starts: ${Thread.currentThread().name}")

    var sum = 0
    println("(before calculation) sum = $sum")

    // creates a worker thread
    GlobalScope.launch {
        println("\ninside thread: ${Thread.currentThread().name}")
        for (i in 1..100) sum += i
        Thread.sleep(2000L)
        println("\nafter thread's work finishes: sum = $sum")
    }

    Thr
    println("\nMain program ends: ${Thread.currentThread().name}")
    println("sum = $sum")
}

