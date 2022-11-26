package com.eru.clean_architecture.presentation.ui.fragment.adapters

import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eru.clean_architecture.databinding.ItemNoteBinding
import com.eru.clean_architecture.domain.model.Note
import java.util.*
import kotlin.collections.ArrayList

class NoteAdapter(private var noteList: ArrayList<Note>): RecyclerView.Adapter<NoteAdapter.ViewHolder>() {


    inner class ViewHolder(private val binding: ItemNoteBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(position: Int) {
            binding.tvTitle.text = noteList[position].title
            binding.tvDesc.text = noteList[position].description
            binding.tvDateCreated.text = getDate(noteList[position].createdAt, "dd-MMMM hh:mm ")
        }

        private fun getDate(milliSeconds: Long, dateFormat: String): String? {
            val formatter = SimpleDateFormat(dateFormat, Locale("ru"))
            val calendar: Calendar = Calendar.getInstance()
            calendar.timeInMillis = milliSeconds
            return formatter.format(calendar.time)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return noteList.size
    }
}