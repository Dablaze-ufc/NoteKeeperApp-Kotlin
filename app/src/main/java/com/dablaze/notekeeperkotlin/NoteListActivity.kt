package com.dablaze.notekeeperkotlin

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.activity_note_list.*

class NoteListActivity : AppCompatActivity() {
    private lateinit var mNavController: NavController
    private lateinit var nextMenuItem: MenuItem
    private lateinit var settingsMenuItem: MenuItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_list)
        setSupportActionBar(toolbar)

        mNavController = Navigation.findNavController(this,R.id.fragment)



        fab.setOnClickListener { view ->
            mNavController.navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
        initDestinationListener()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        nextMenuItem = menu?.findItem(R.id.action_next)!!
        settingsMenuItem = menu.findItem(R.id.action_settings)
        return true
    }

    fun initDestinationListener(){
        mNavController.addOnDestinationChangedListener{controller, destination, arguments ->
           when(destination.id){
               R.id.FirstFragment -> hideMenuItems()
               R.id.SecondFragment -> showMenuItems()
           }

        }
    }

    private fun showMenuItems() {
        nextMenuItem.isVisible = true
        settingsMenuItem.isVisible = true
    }

    private fun hideMenuItems() {

        nextMenuItem.isVisible = false
        settingsMenuItem.isVisible = false
        
    }

}
