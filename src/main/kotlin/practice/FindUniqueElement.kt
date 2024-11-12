package practice

fun main(){
    val arr = intArrayOf(2, 3, 5, 4, 5, 3, 4)
    val uniqueElement = findUniqueElement(arr)
    println("The element that occurred only once is: $uniqueElement")
}

fun findUniqueElement(arr: IntArray): Int {
    var result = 0
    val newlist = arr.groupBy { it }
    for ((key, value ) in newlist){
        if (value.count() == 1){
            result = key
        }
    }
    return result
}