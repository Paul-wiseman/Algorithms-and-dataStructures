package practice.leetcode

import java.util.*

fun main() {
    println(validParentheses("([}}])"))
}

fun validParentheses(s: String): Boolean {
    val stack: Stack<Char> = Stack()
    if (s.length % 2 != 0) {
        return false
    }

    for (i in 0..s.lastIndex) {
        when (s[i]) {
            '(', '[', '{' -> stack.push(s[i])
            ')', ']', '}' -> {
                if (stack.isNotEmpty() && s[i] == ')' && stack.peek() == '(') {
                    stack.pop()
                }else if (stack.isNotEmpty() && s[i] == ']' && stack.peek() == '['){
                    stack.pop()
                }else if(stack.isNotEmpty() && s[i] == '}' && stack.peek() == '{'){
                    stack.pop()
                }else{
                    stack.push(s[i])
                }
            }
        }
    }

    return stack.isEmpty()
}
