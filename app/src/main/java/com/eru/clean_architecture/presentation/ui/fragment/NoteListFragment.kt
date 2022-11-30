package com.eru.clean_architecture.presentation.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.eru.clean_architecture.databinding.FragmentNoteListBinding
import com.eru.clean_architecture.domain.model.Note
import com.eru.clean_architecture.presentation.UiState
import com.eru.clean_architecture.presentation.ui.fragment.adapters.NoteAdapter
import kotlinx.coroutines.launch

class NoteListFragment : Fragment() {
    private lateinit var binding: FragmentNoteListBinding
    private var noteList = arrayListOf<Note>()
    private val viewModel: NoteListViewModel by viewModels()
    private val adapter = NoteAdapter(noteList)

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.getAllNotes()

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.getAllNotesState.collect{ state ->
                    when (state){
                        is UiState.Loading -> {
                            //TODO show progress bar
                        }
                        is UiState.Error -> {
                            Toast.makeText(context, state.message, Toast.LENGTH_SHORT).show()
                        }
                        is UiState.Success -> {
                            noteList.addAll(state.data)
                            adapter.notifyDataSetChanged()
                        }
                        is UiState.Empty -> {}
                    }
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNoteListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.adapter = adapter
    }

}