package com.dablaze.notekeeperkotlin

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class DataManagerTest {
    @Before
    fun setUp() {
        DataManager.notes.clear()
        DataManager.initializeCourses()
    }

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

    @Test
    fun findSimilarNote(){
        val course = DataManager.courses.get("android_async")!!
        val noteTittle = "This is a test Note tittle"
        val noteText1 = "Tis is a test note text"
        val noteText2 = "Tis is a test note text of note 2"

        val index1 = DataManager.addNote(course,noteTittle,noteText1)
        val index2 = DataManager.addNote(course,noteTittle,noteText2)

        val note1 = DataManager.findNote(course,noteTittle,noteText1)
        val foundIndex = DataManager.notes.indexOf(note1)
        assertEquals(index1, foundIndex)

        val note2 = DataManager.findNote(course,noteTittle,noteText2)
        val foundIndex2 = DataManager.notes.indexOf(note2)
        assertEquals(index2, foundIndex2)
    }
}