package com.rdhd.app.ui.customview

import android.annotation.TargetApi
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.os.Build
import android.util.AttributeSet
import android.view.View
import androidx.core.graphics.toColorInt
import com.rdhd.app.utils.convertDpToPixel


class RoundedRectangleShadow: View {

    @JvmOverloads
    constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0)
            : super(context, attrs, defStyleAttr)

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(
        context: Context,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int)
            : super(context, attrs, defStyleAttr, defStyleRes)

    var shadowRadius = convertDpToPixel(15F, context)
    var shadowColor = "#333333".toColorInt()
    var bgColor = Color.WHITE


    var paint = Paint(Paint.ANTI_ALIAS_FLAG)

    init {
        setLayerType(LAYER_TYPE_SOFTWARE, paint)
        paint.setShadowLayer(shadowRadius.toFloat(), 0f, 0f, shadowColor)
        paint.color = bgColor
    }

    override fun onDraw(canvas: Canvas?) {
        val rect = RectF(0F, shadowRadius, width.toFloat(), height.toFloat() - shadowRadius)
        canvas?.drawRoundRect(rect, shadowRadius, shadowRadius, paint)
        super.onDraw(canvas)
    }
}