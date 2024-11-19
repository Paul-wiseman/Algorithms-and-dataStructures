package practice.coderbyte

fun main() {
    val input = arrayOf(
        "4","0:1","2:2","1:2","3:1"
    )


    println(gasStation(input))
    val currentStation = input[1].split(":")
    var gas = currentStation[0].toInt() - currentStation[0].toInt()
    println(0-2)
}

fun gasStation(input: Array<String>): String {
    for (i in 1..input.lastIndex) {
        val currentStation = input[i].split(":")
        var gas = currentStation[0].toInt() - currentStation[1].toInt()
        if (gas<0) continue
        for (j in (i + 1)..input.lastIndex) {
            var (gasReceived, gasSpent) = input[j].split(":")
            gas += gasReceived.toInt()
            gas -= gasSpent.toInt()
            if (gas<0) break
        }
        if (gas>=0){
            return i.toString()
        }
    }

    return "Impossible"
}

fun gasStation1(input: Array<String>): String {
    val netGas = IntArray(input.size)
    var minGas = Int.MAX_VALUE
    var minIndex = 0
    var sum = 0

    for (i in 1 ..input.lastIndex) {
        val (gasReceived, gasSpent) = input[i].split(":")
        netGas[i] = gasReceived.toInt() - gasSpent.toInt()
        sum += netGas[i]

        if (sum < minGas) {
            minGas = sum
            minIndex = i
        }
    }

    return if (sum >= 0) (minIndex % input.size).toString() else "Impossible"
}
