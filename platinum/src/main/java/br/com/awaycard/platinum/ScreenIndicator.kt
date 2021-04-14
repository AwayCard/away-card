package br.com.awaycard.platinum

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.LinearLayoutCompat

class ScreenIndicator(
    context: Context,
    attrs: AttributeSet
) : LinearLayoutCompat(context, attrs) {

    init {
        inflate(context, R.layout.screen_indicator, this)

        val indicator = context.obtainStyledAttributes(
            attrs,
            R.styleable.ScreenIndicator
        )

        findViewById<AppCompatTextView>(R.id.nextIndicator).text = indicator.getString(R.styleable.ScreenIndicator_text)
        indicator.recycle()
    }
}