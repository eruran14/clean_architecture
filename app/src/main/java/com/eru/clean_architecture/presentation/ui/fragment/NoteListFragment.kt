package com.eru.clean_architecture.presentation.ui.fragment

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.eru.clean_architecture.R
import com.eru.clean_architecture.databinding.FragmentNoteListBinding
import com.eru.clean_architecture.domain.model.Note
import com.eru.clean_architecture.presentation.base.BaseFragment
import com.eru.clean_architecture.presentation.ui.fragment.adapters.NoteAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoteListFragment : BaseFragment(R.layout.fragment_note_list) {
    private val binding by viewBinding(FragmentNoteListBinding::bind)
    private var noteList = arrayListOf<Note>()
    private val viewModel: NoteListViewModel by viewModels()
    private val noteAdapter by lazy {
        NoteAdapter(noteList)
    }


    override fun initialize() {
        binding.recyclerView.apply {
            layoutManager =
                LinearLayoutManager(
                    requireContext(),
                    LinearLayoutManager.VERTICAL,
                    false
                )
            adapter = noteAdapter
        }
    }

    override fun setUpRequests() {
        viewModel.getAllNotes()

//        adapter = NoteAdapter(noteList) { title, desc ->
//            val alertDialog = AlertDialog.Builder(requireContext())
//            alertDialog.setMessage("Хотите изменить заметку?")
//            alertDialog.setPositiveButton("Да") { _, _ ->
//                findNavController().navigate(R.id.addNoteFragment, Bundle().apply {
//                    putString(KEY_FOR_TITLE, title)
//                    putString(KEY_FOR_DESC, desc)
//                })
//            }
//        }

    }

    @SuppressLint("NotifyDataSetChanged")
    override fun setUpObservers() {
        viewModel.getAllNotesState.collectState(
            onLoading = {
                binding.progressBar.isVisible = true
            },
            onError = { message ->
                Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
            },
            onSuccess = { data ->
                noteList.addAll(data)
                noteAdapter.notifyDataSetChanged()
            }
        )

    }

    companion object {
        const val KEY_FOR_TITLE = "title"
        const val KEY_FOR_DESC = "description"
    }

}