package com.dablaze.notekeeperkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity : AppCompatActivity() {
    private lateinit var mNavController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        mNavController = Navigation.findNavController(this,R.id.fragment)



        fab.setOnClickListener {
            mNavController.navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
        initDestinationListener()
    }





    private fun initDestinationListener(){
        mNavController.addOnDestinationChangedListener{ _, destination, _ ->
           when(destination.id){
               R.id.FirstFragment -> showToolbar()
               R.id.SecondFragment -> hideToolbar()
           }

        }
    }

    private fun showToolbar() {
       toolbar.isVisible = true
    }

    private fun hideToolbar() {
        toolbar.isVisible  = false
    }

}
