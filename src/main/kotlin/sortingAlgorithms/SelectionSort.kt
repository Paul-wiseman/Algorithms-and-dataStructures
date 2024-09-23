package sortingAlgorithms

import swap
import testArrayForSorting

fun main(){
    println(selectionSort(testArrayForSorting).contentToString())
}

fun selectionSort(arr: Array<Int>):Array<Int>{
    for (i in arr.indices.reversed()){
        var largestIndex = 0
        for (j in 1 .. i){
            if (arr[j] > arr[largestIndex]){
                largestIndex = j
            }
        }
        swap(arr, largestIndex, i)
    }

    return arr
}