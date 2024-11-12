package practice.leetcode

fun main() {

    val list = Node(1, Node(2, Node(3, Node(4, Node(5, Node(6))))))
    println(list.printInReverse())
}

// TODO
fun mergeTwoSortedLists(list1: Node<Int>?, list2: Node<Int>?) {

}

data class Node<T : Any>(
    var value: T,
    var next: Node<T>? = null
) {
    override fun toString(): String {
        return if (next != null) {
            "$value -> ${next.toString()}"
        } else {
            "$value"
        }
    }

    fun printInReverse() {
        next?.printInReverse()
        if (next != null) {
            print(" -> ")
        }

        print(value.toString())
    }
}