package com.dablaze.notekeeperkotlin

import androidx.test.espresso.Espresso.*
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.hamcrest.Matchers.*
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class )
class CreateNewNoteTest{
    @Rule @JvmField
    val mainActivity = ActivityTestRule(HomeActivity::class.java)
    @Test
    fun createNewNote(){

        val course = DataManager.courses["android_async"]
        val noteTittle = "Note tittle"
        val noteText = "Note Text"
        onView(withId(R.id.fab)).perform(click())

        onView(withId(R.id.spinnerCourses)).perform(click())
        onData(allOf(instanceOf(CourseInfo::class.java), equalTo(course))).perform(click())

        onView(withId(R.id.textNoteTittle)).perform(typeText(noteTittle))
        onView(withId(R.id.textNoteText)).perform(typeText(noteText), closeSoftKeyboard())



        pressBack()

        val newNote = DataManager.notes.last()
        assertEquals(course,newNote.course)
        assertEquals(noteText,newNote.text)
        assertEquals(noteTittle,newNote.tittle)
    }
}