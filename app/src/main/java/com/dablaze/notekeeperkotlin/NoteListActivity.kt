package com.dablaze.notekeeperkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.activity_note_list.*

class NoteListActivity : AppCompatActivity() {
    private lateinit var mNavController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_list)
        setSupportActionBar(toolbar)

        mNavController = Navigation.findNavController(this,R.id.fragment)



        fab.setOnClickListener { view ->
            mNavController.navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

}
