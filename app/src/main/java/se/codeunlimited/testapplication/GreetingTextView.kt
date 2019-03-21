package se.codeunlimited.testapplication

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import androidx.annotation.VisibleForTesting

class GreetingTextView @JvmOverloads constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int = 0) : TextView(context, attrs, defStyleAttr) {

    var name: String? = null
        set(name) {
            field = clean(name)
            sayHello()
        }

    init {
        val a = context.obtainStyledAttributes(attrs, R.styleable.GreetingTextViewr)
        name = a.getString(R.styleable.GreetingTextViewr_name)
        a.recycle()

        setOnClickListener {
            text = "How are you?"
        }
    }

    private fun sayHello() {
        text = if (name.isNullOrBlank()) "Hello" else "Hello $name"
    }

    @VisibleForTesting
    fun clean(name: String?): String? = name?.trim()
}