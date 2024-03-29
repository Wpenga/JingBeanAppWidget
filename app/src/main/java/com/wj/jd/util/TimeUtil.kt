package com.wj.jd.util

import java.text.SimpleDateFormat
import java.util.*

object TimeUtil {
    fun getCurrentData(): String {
        val formatter = SimpleDateFormat("HH:mm:ss")
        val date = Date(System.currentTimeMillis())
        return formatter.format(date)
    }

    fun getCurrentHH(): Int {
        val formatter = SimpleDateFormat("HH")
        val date = Date(System.currentTimeMillis())
        return formatter.format(date).toInt()
    }

    fun getTodayMillis(ago: Int): Long {
        var data = Date()
        var calendar = Calendar.getInstance()
        calendar.time = data
        calendar.add(Calendar.DAY_OF_MONTH, ago)
        var format = SimpleDateFormat("yyyy-MM-dd")
        var strData = format.format(calendar.time)
        val split = strData.split("-")
        calendar.clear()
        calendar.set(split[0].toInt(), split[1].toInt() - 1, split[2].toInt())
        return calendar.timeInMillis
    }

    fun parseTime(timeStr: String): Long? {
        try {
            val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            return simpleDateFormat.parse(timeStr).time
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return 0L
    }
}