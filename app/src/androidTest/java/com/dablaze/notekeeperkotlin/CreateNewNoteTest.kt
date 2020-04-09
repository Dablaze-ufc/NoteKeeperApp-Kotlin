package com.dablaze.notekeeperkotlin

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class )
class CreateNewNoteTest{
    @Rule @JvmField
    val mainActivity = ActivityTestRule(HomeActivity::class.java)
    @Test
    fun createNewNote(){
        val noteTittle = "Note tittle"
        val noteText = "Note Text"
        onView(withId(R.id.fab)).perform(click())

        onView(withId(R.id.textNoteTittle)).perform(typeText(noteTittle))
        onView(withId(R.id.textNoteText)).perform(typeText(noteText))
    }
}