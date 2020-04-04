package com.dablaze.notekeeperkotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class NoteListFragment : Fragment() {
    private lateinit var listView: ListView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root =inflater.inflate(R.layout.fragment_note_list, container, false)
        listView = root.findViewById(R.id.listNotes)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listView.adapter = ArrayAdapter(requireContext(),android.R.layout.simple_list_item_1,
        DataManager.notes)

        listView.setOnItemClickListener{parent, view, position, id ->
            val bundle = Bundle()
            bundle.putInt(NOTE_POSITION, position)
            Navigation.findNavController(view).navigate(R.id.SecondFragment,bundle)
        }


    }
}
