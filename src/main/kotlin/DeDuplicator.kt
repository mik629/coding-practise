package main.kotlin

fun main(args: Array<String>) {
    System.setProperty("-XX:MaxMetaspaceSize", "10m")
    System.setProperty("-XX:MetaspaceSize", "5m")
    val n = readLine()!!.toInt()
    var prevDuplicate: Int? = null
    for (i in 0 until n) {
        val next = readLine()!!.toInt()
        if (next != prevDuplicate) {
            println(next)
            prevDuplicate = next
        }
    }
}