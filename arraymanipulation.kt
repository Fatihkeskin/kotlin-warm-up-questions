import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*


fun arrayManipulation(n: Int, queries: Array<Array<Int>>): Long {
    
    var numbers = Array<Long>(n+1){0.toLong()}
    var max = 0.toLong()

    for(i in 0..queries.size-1) {
        var a = queries[i][0]-1
        var b = queries[i][1]
        var k = queries[i][2]
        numbers.set(a, numbers[a]+k) 
        numbers.set(b, numbers[b]-k)
    }

    for(i in 1..numbers.size-1) {
        numbers[i] += numbers[i - 1]
        if(numbers[i]>max) max = numbers[i]
    }
    
    return max;
}

fun main(args: Array<String>) {
    val first_multiple_input = readLine()!!.trimEnd().split(" ")

    val n = first_multiple_input[0].toInt()

    val m = first_multiple_input[1].toInt()

    val queries = Array<Array<Int>>(m, { Array<Int>(3, { 0 }) })

    for (i in 0 until m) {
        queries[i] = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
    }

    val result = arrayManipulation(n, queries)

    println(result)
}