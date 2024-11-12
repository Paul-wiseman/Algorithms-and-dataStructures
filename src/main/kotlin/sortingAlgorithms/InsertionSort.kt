package sortingAlgorithms

import testArrayForSorting

fun main(){
    println(3024/100)
    println(isPalindrome(123123))
}

fun insertionSort(arr: Array<Int>):Array<Int>{

    for (i in 1..arr.size){
        var newElement = arr[i]

    }

    return arr
}

fun isPalindrome(x: Int): Boolean {
    val input = x.toString()
    var result = false
    var l = 0
    var r = input.length-1
    while(l<r){
        if(input.get(l) == input.get(r)){
            result = true
            break
        }else{
            l++
            r--
        }
    }

    return result
}
