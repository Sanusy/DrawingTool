package com.gmail.ivan.morozyk.drawingtool

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.RectF
import android.os.Parcelable
import android.util.AttributeSet
import android.view.View

class DrawView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAtr: Int = 0
) : View(context, attributeSet, defStyleAtr) {

    private var nextStartAngle: Float = 0f

    private var rect: RectF? = null

    private val arcList = mutableListOf<Arc>()

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        if (rect == null) {
            rect = if (measuredHeight > measuredWidth) RectF(
                0f,
                (measuredHeight / 2 - measuredWidth / 2).toFloat(),
                measuredWidth.toFloat(),
                (measuredHeight / 2 + measuredWidth / 2).toFloat()
            ) else RectF(
                (measuredWidth / 2 - measuredHeight / 2).toFloat(),
                0f,
                (measuredWidth / 2 + measuredHeight / 2).toFloat(),
                measuredHeight.toFloat()
            )
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        arcList.forEach {
            canvas?.drawArc(
                rect!!,
                it.startAngle,
                it.sweepAngle,
                true,
                it.color.paint
            )
        }
    }

    fun drawArc(sweepAngle: Float, color: ArcColor) {
        arcList.add(Arc(nextStartAngle, sweepAngle, color))
        nextStartAngle += sweepAngle
        invalidate()
    }
}

