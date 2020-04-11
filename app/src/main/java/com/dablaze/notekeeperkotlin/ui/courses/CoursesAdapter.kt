package com.dablaze.notekeeperkotlin.ui.courses

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dablaze.notekeeperkotlin.CourseInfo
import com.dablaze.notekeeperkotlin.R

class CoursesAdapter(private val context: Context, private var courses: List<CourseInfo> ):
    RecyclerView.Adapter<CoursesAdapter.ViewHolder>() {


    private val layoutInflater =  LayoutInflater.from(context)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.list_item_courses, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount() = courses.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val course = courses[position]
        holder.textCourse.text = course.tittle
        holder.notePosition = position
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var notePosition = 0
        val textCourse = itemView.findViewById<TextView>(R.id.textCourseTittle)
    }
}