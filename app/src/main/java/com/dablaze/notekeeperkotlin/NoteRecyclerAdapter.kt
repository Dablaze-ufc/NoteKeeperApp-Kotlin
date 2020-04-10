package com.dablaze.notekeeperkotlin

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView

class NoteRecyclerAdapter(private val context: Context, private val notes:List<NoteInfo>) :
    RecyclerView.Adapter<NoteRecyclerAdapter.NoteViewHolder>() {

private val layoutInflater =  LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
       val itemView = layoutInflater.inflate(R.layout.listnotesitems, parent, false)
        return NoteViewHolder(itemView)
    }

    override fun getItemCount() = notes.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note =notes[position]
        holder.textCourse.text = note.course?.tittle
        holder.textTittle.text = note.tittle
        holder.notePosition = position
    }

    inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var notePosition = 0
        val textCourse = itemView.findViewById<TextView>(R.id.textCourse)
        val textTittle = itemView.findViewById<TextView>(R.id.textTittle)
        init {
            itemView.setOnClickListener {
                val bundle = Bundle()
                bundle.putInt(NOTE_POSITION, notePosition)

                Navigation.findNavController(it).navigate(R.id.action_NoteListFragment_to_NoteFragment, bundle)
            }
        }
    }
}