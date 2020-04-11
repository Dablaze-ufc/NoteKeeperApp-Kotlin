package com.dablaze.notekeeperkotlin.ui.notesList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dablaze.notekeeperkotlin.DataManager
import com.dablaze.notekeeperkotlin.R

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
@Suppress("NAME_SHADOWING")
class NoteListFragment : Fragment() {
    private lateinit var listView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root =inflater.inflate(R.layout.fragment_note_list, container, false)
        listView = root.findViewById(R.id.listItems)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listView.layoutManager = LinearLayoutManager(requireContext())

        listView.adapter =
            NoteRecyclerAdapter(
                requireContext(),
                DataManager.notes
            )


    }

    override fun onResume() {
        super.onResume()
        listView.adapter?.notifyDataSetChanged()
    }
}
