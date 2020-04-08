package com.dablaze.notekeeperkotlin

import org.junit.Assert.assertEquals
import org.junit.Test

class DataManagerTest {

    @Test
    fun addNote() {
        val course = DataManager.courses.get("android_async")!!
        val noteTittle = "This is a test Note tittle"
        val noteTest = "Tis is a test note text"

        val index = DataManager.addNote(course,noteTittle,noteTest)
        val note = DataManager.notes[index]

        assertEquals(course, note.course)
        assertEquals(noteTittle, note.tittle)
        assertEquals(noteTest, note.text)
    }
}