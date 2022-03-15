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

/*
 * Complete the 'jumpingOnClouds' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts INTEGER_ARRAY c as parameter.
 */

fun jumpingOnClouds(c: Array<Int>): Int {
    // Write your code here
    
    var currentIndex = 0
    var oneStepAheadIndex = 2
    var jumps = 0
        
    for(i in 0..c.size-2){
        if(i == currentIndex){
            if(c[currentIndex] == 0 && i < c.size-2 && c[oneStepAheadIndex] == 0){
                currentIndex = oneStepAheadIndex
                jumps++
            }else if(c[currentIndex] == 0){
                currentIndex++
                jumps++
            }
            oneStepAheadIndex = currentIndex+2  
        }
    }
    
    return jumps

}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val c = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val result = jumpingOnClouds(c)

    println(result)
}