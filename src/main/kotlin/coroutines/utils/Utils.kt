package coroutines.utils

class Utils {
    fun startProgramMessage(threadName: String) {
        println("\n$threadName: main program starts" +
                "\n----------------------------------------\n")
    }

    fun endProgramMessage(threadName: String) {
        println("\n----------------------------------------" +
                "\n$threadName: main program ends")
    }
}