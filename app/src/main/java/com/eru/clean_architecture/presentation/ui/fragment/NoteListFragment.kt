package com.eru.clean_architecture.presentation.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eru.clean_architecture.databinding.FragmentNoteListBinding
import com.eru.clean_architecture.domain.model.Note
import com.eru.clean_architecture.presentation.ui.fragment.adapters.NoteAdapter

class NoteListFragment : Fragment() {
    private lateinit var binding: FragmentNoteListBinding
    private var noteList = arrayListOf<Note>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNoteListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = NoteAdapter(noteList)
        binding.recyclerView.adapter = adapter
    }

}