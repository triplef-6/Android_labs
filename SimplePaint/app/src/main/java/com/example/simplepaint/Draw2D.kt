package com.example.simplepaint

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.view.View

class Draw2D(context: Context?) : View(context) {
    private val paint: Paint = Paint()
    private val rect: Rect = Rect()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        paint.apply { // закрашиваем холст чёрным
            style = Paint.Style.FILL
            color = Color.BLACK
        }
        canvas?.drawPaint(paint)

        paint.apply { // жёлтый круг
            isAntiAlias = true
            color = Color.YELLOW
        }
        canvas?.drawCircle(950F, 30F, 25F, paint)

        // зелёный прямоугольник
        paint.color = Color.GREEN
        canvas?.drawRect(20F, 650F, 950F, 777F, paint)

        paint.apply { // текст  поверх лужайки
            color = Color.RED
            style = Paint.Style.FILL
            isAntiAlias = true
            textSize = 66F
        }
        canvas?.drawText("Лужайка только для котов", 30F, 648F, paint)

        // лучик солнца
        val x = 810F
        val y = 190F

        paint.apply {
            color = Color.GRAY
            style = Paint.Style.FILL
            textSize = 27F
        }

        val str2rotate = "Лучик солнца!"

        canvas?.save()
        canvas?.rotate(-45F, x + rect.exactCenterX(), y + rect.exactCenterY())
        canvas?.drawText(str2rotate, x, y, paint)

        canvas?.restore()

//        canvas.drawBitmap(mBitmap, 450, 530, mPaint);
    }
}
