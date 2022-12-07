package com.eru.clean_architecture.presentation.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.eru.clean_architecture.R
import com.eru.clean_architecture.databinding.FragmentAddNoteBinding
import com.eru.clean_architecture.domain.model.Note
import com.eru.clean_architecture.presentation.base.BaseFragment
import kotlinx.coroutines.launch

class AddNoteFragment : BaseFragment(R.layout.fragment_add_note) {
    private val viewModel: AddNoteViewModel by viewModels()
    private val binding by viewBinding(FragmentAddNoteBinding::bind)

    override fun initialize() {

    }

    override fun setUpRequests() {
        viewModel.createNote(
            Note(
                title = binding.addTitle.text.toString(),
                description = binding.etAddDesc.text.toString(),
                createdAt = System.currentTimeMillis()
            )
        )
    }
}