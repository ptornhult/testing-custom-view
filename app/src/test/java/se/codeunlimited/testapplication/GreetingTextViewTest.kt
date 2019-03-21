package se.codeunlimited.testapplication

import android.app.Activity
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.android.controller.ActivityController
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(application = TestApplication::class)
class GreetingTextViewTest {

    private lateinit var activityController: ActivityController<Activity>
    private lateinit var activity: Activity

    private lateinit var greetingTextView: GreetingTextView

    @Before
    fun setUp() {
        // Create an activity (Can be any sub-class: i.e. AppCompatActivity, FragmentActivity, etc)
        activityController = Robolectric.buildActivity(Activity::class.java)
        activity = activityController.get()

        // Create the view using the activity context
        greetingTextView = GreetingTextView(activity)
    }

    @Test
    fun `should display "Hello" when no name has been set`() {
        assertEquals("Hello", greetingTextView.text)
    }

    @Test
    fun `should display "Hello $name" when name has been set`() {
        greetingTextView.name = "John"
        assertEquals("Hello John", greetingTextView.text)
    }

    @Test
    fun `should trim name`() {
        greetingTextView.name = "           John  "
        assertEquals("John", greetingTextView.name)
    }

    @Test
    fun `can clear name`() {
        greetingTextView.name = null
        assertNull(greetingTextView.name)
        assertEquals("Hello", greetingTextView.text)
    }
}