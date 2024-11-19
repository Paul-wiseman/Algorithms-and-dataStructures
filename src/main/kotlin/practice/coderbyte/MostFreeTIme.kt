package practice.coderbyte

fun main() {
    val input = arrayOf(
        "12:15PM-02:00PM", "09:00AM-10:00AM", "10:30AM-12:00PM"
    )
    println(mostFreeTime(input))
    val hour = 60 * 5
    println(hour % 60)
}

//fun mostFreeTime(strArr: Array<String>): String {
//    var freeHour = 0.0
//    val sortedTimePair = strArr.map { range ->
//        val (startTime, endTime) = range.split("-")
//        Pair(startTime, endTime)
//    }.sortedBy { timePair: Pair<String, String> ->
//        val (hour, minute) = timePair.first.split(":")
//        hour.toInt() + (minute.substring(0, 2).toInt()) / 100.00
//    }
//
//    for (i in 0..sortedTimePair.lastIndex - 1) {
//        val (currentHour, minute) = sortedTimePair[i].second.split(":")
//        val (nextHour, nextMinute) = sortedTimePair[i + 1].first.split(":")
//        val totalHour = (nextHour.toInt() - currentHour.toInt())
//        val totalMinute = (nextMinute.substring(0, 2).toInt() - minute.substring(0, 2).toInt()) / 100.00
//        val total = totalHour + totalMinute / 100.00
//
//        freeHour = max(freeHour, total)
////        freeMinute = max(freeMinute, totalMinute)
//    }
//
//    println(freeHour)
//
//    val (hour, minute) = freeHour.toString().split(".")
//    return "${hour.toInt().formatNumber()}:${(minute.toInt() * 10).formatNumber()}"
//}

fun Int.formatNumber(): String {
    return if (this < 10) "0$this" else this.toString()
}

fun turnMinutes(time: String): Int {
    val (hours, minutes) = time.substring(0, 2).toInt() to time.substring(3, 5).toInt()
    val isPM = time.endsWith("PM")
    val hours24 = if (isPM && hours != 12) hours + 12 else hours
    return hours24 * 60 + minutes
}

fun convertTimeToMinutes(time: String): Int {
    val (hours, minutes) = time.substring(0, 2).toInt() to time.substring(3, 5).toInt()
    val isMorningOrAfter = time.endsWith("PM")
    val totalHours = if (isMorningOrAfter && hours != 12) hours + 12 else hours
    return totalHours * 60 + minutes
}

fun mostFreeTime(strArr: Array<String>): String {
    val timeRanges = strArr
        .map { it.split("-") }
        .map { (start, end) ->
            turnMinutes(start) to turnMinutes(end)
        }
        .sortedBy { it.first }.also {
            println(it)
        }

    var maxFreeTime = 0
    for (i in 0 until timeRanges.lastIndex) {
        val (end1, start2) = timeRanges[i].second to timeRanges[i + 1].first
        maxFreeTime = maxOf(maxFreeTime, start2 - end1)
    }

    val hours = maxFreeTime / 60
    val minutes = maxFreeTime % 60
    return "%02d:%02d".format(hours, minutes)
}
