package se.codeunlimited.testapplication

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView

class FibonacciTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : TextView(context, attrs, defStyleAttr) {

    private var numbers = arrayOf(0, 1)

    fun next() {
        val value = currentValue
        numbers[0] = numbers[1]
        numbers[1] = value
        updateView()
    }

    init {
        updateView()

        setOnClickListener {
            next()
        }
    }

    private fun updateView() {
        text = "$currentValue"
    }

    val currentValue: Int
        get() = numbers[0] + numbers[1]
}