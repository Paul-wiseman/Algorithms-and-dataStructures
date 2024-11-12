package practice.leetcode


fun main() {
    val nums = intArrayOf(1)
    val k = 0
    println(subArraySum(nums, k))
}

private fun subArraySum(nums: IntArray, k: Int): Int {
    var counter = 0
    var sum = 0
    val hashMap = HashMap<Int, Int>()
    hashMap[0] = 1

    for (num in nums) {
        sum += num
        val currentDifference = sum - k
        if (hashMap.containsKey(currentDifference)) {
            counter+= hashMap[currentDifference]!!
        }
        hashMap[sum] = hashMap.getOrDefault(sum, 0) + 1
    }
        hashMap.keys.forEach {
        println("for key $it the value is ${hashMap[it]}")
    }

    return counter
}

fun subarraySum(nums: IntArray, k: Int): Int {
    var count = 0
    var sum = 0
    val map = HashMap<Int, Int>()
    map[0] = 1
    for (i in nums.indices) {
        sum += nums[i]
        if (map.containsKey(sum - k)) count += map[sum - k]!!
        map[sum] = map.getOrDefault(sum, 0) + 1
    }
    return count
}
