
val testArrayForSorting = arrayOf(20,35,-15,7,55,1,-22)

// a function to swap two elements of an array
fun swap(arr: Array<Int>, i: Int, j:Int){
    if(arr[i] == arr[j]) return

    val temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp
}
