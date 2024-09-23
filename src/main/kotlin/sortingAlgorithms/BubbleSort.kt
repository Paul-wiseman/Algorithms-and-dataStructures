package sortingAlgorithms

import swap
import testArrayForSorting

fun main(){
    println(bubbleSort(testArrayForSorting).contentToString())
}
// test array
fun bubbleSort(arr:Array<Int>):Array<Int>{

    for(value in arr.indices.reversed()){
        for (current in 0 until value){
            if (arr[current] > arr[current + 1]){
                swap(arr, current, current+1)
            }
        }
    }
    return arr
}