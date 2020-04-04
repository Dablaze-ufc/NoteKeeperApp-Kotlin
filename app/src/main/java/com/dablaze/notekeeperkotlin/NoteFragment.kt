package com.dablaze.notekeeperkotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_note.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class NoteFragment : Fragment() {

    private lateinit var spinnerCourses: Spinner
    private var notePosition = POSITION_NOT_SET
    private lateinit var toolbar: Toolbar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
      val root =inflater.inflate(R.layout.fragment_note, container, false)
        toolbar = root.findViewById<Toolbar>(R.id.toolbar)
        toolbar.inflateMenu(R.menu.menu_main)
        toolbar.setOnMenuItemClickListener { item ->
            when(item.itemId){
                R.id.action_next ->{
                    nextNote()
                    true
                }
                else -> false
            }
        }
        spinnerCourses = root.findViewById(R.id.spinnerCourses)

        return root
    }

    private fun nextNote() {
        ++notePosition
        displayNotes()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val adapterCourses = ArrayAdapter(requireContext(),android.R.layout.simple_spinner_item,
            DataManager.courses.values.toList())
        adapterCourses.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinnerCourses.adapter = adapterCourses

        val args = arguments
        notePosition = args?.getInt(EXTRA_NOTE_POSITION) ?: POSITION_NOT_SET

        if (notePosition != POSITION_NOT_SET)
            displayNotes()
        else toolbar.title = "New Note"

    }

    private fun displayNotes() {
        val note = DataManager.notes[notePosition]
        val coursePosition = DataManager.courses.values.indexOf(note.course)
        textNoteTittle.editText?.setText(note.tittle)
        toolbar.title = note.tittle
        textNoteText.editText?.setText(note.text)
        spinnerCourses.setSelection(coursePosition)
    }
}
