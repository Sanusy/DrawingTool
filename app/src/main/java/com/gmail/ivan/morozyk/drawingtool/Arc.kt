package com.gmail.ivan.morozyk.drawingtool

import android.graphics.Color
import android.graphics.Paint

data class Arc(val startAngle: Float, val sweepAngle: Float, val color: ArcColor)

enum class ArcColor(val paint: Paint) {
    RED(redPaint),
    GREEN(greenPaint),
    BLUE(bluePaint)
}

private val redPaint = Paint().apply {
    isAntiAlias = true
    color = Color.RED
    style = Paint.Style.FILL
}

private val bluePaint = Paint().apply {
    isAntiAlias = true
    color = Color.BLUE
    style = Paint.Style.FILL
}

private val greenPaint = Paint().apply {
    isAntiAlias = true
    color = Color.GREEN
    style = Paint.Style.FILL
}