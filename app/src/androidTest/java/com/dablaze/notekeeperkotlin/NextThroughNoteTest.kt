package com.dablaze.notekeeperkotlin


import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.hamcrest.Matchers.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NextThroughNoteTest{

    @Rule @JvmField
    val homeActivity = ActivityTestRule(HomeActivity::class.java)

    @Test
    fun nextThroughNotes(){
        onData(allOf(instanceOf(NoteInfo::class.java), equalTo(DataManager.notes[0]))).perform(click())

        for (index in 0..DataManager.notes.lastIndex){
            val note = DataManager.notes[index]

            onView(withId(R.id.spinnerCourses)).check(matches(withSpinnerText(note.course?.tittle)))

            onView(withId(R.id.textNoteText)).check(matches(withText(note.text)))
            onView(withId(R.id.textNoteTittle)).check(matches(withText(note.tittle)))

            if (index != DataManager.notes.lastIndex){
                onView(allOf(withId(R.id.action_next), isEnabled())).perform(click())
            }

        }
        onView(withId(R.id.action_next)).check(matches(isEnabled()))
    }
}