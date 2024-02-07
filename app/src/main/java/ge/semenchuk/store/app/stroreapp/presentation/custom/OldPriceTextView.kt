package ge.semenchuk.store.app.stroreapp.presentation.custom

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import ge.semenchuk.store.app.stroreapp.R

class OldPriceTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : AppCompatTextView(context, attrs, defStyleAttr) {

    private val linePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = context.resources.getColor(R.color.grey, context.theme)
        strokeWidth = 4f
        style = Paint.Style.STROKE
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawLine(-50f, height.toFloat(), width.toFloat(), 15f, linePaint)
    }
}