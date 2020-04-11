package com.dablaze.notekeeperkotlin.ui.courses

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dablaze.notekeeperkotlin.DataManager
import com.dablaze.notekeeperkotlin.R

class CourseFragment : Fragment() {

    private lateinit var galleryViewModel: GalleryViewModel
    private lateinit var listView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        galleryViewModel =
            ViewModelProviders.of(this).get(GalleryViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_courses, container, false)
        listView = root.findViewById(R.id.recyclerView)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listView.layoutManager = GridLayoutManager(requireContext(),2)

        listView.adapter = CoursesAdapter(requireContext(), DataManager.courses.values.toList())
    }
}
