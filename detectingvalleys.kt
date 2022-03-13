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
 * Complete the 'countingValleys' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER steps
 *  2. STRING path
 */

fun countingValleys(steps: Int, path: String): Int {
    // Write your code here
    
    var upCount = 0
    var downCount = 0
    var isUnderSeaLevel = false
    var valleyCount = 0
    
    for(step in path){
        if(step == 'U' && downCount == 0){
            upCount++
        }
        else if(step == 'U' && downCount == 1){
            downCount = 0
            if(isUnderSeaLevel){
                valleyCount++
                isUnderSeaLevel = false
            }
        }
        else if(step == 'U' && downCount != 0){
            downCount--
        }
        else if(step == 'D' && upCount == 0){
            downCount++
            isUnderSeaLevel = true
        }
        else if(step == 'D' && upCount != 0){
            upCount--
        }
    }
    return valleyCount

}


fun main(args: Array<String>) {
    val steps = readLine()!!.trim().toInt()

    val path = readLine()!!

    val result = countingValleys(steps, path)

    println(result)
}

