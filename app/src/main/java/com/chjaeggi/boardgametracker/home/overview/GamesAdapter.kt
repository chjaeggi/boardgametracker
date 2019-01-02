package com.chjaeggi.boardgametracker.home.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.chjaeggi.boardgametracker.R
import com.chjaeggi.boardgametracker.databinding.ListItemGameBinding

class GamesAdapter : RecyclerView.Adapter<GamesAdapter.ViewHolder>() {

    private var items: List<ListItemGame> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemGameBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position])

    override fun getItemCount(): Int = items.size

    fun replaceData(list: List<ListItemGame>) {
        items = list
    }

    inner class ViewHolder(val binding: ListItemGameBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ListItemGame) {
            binding.root.setOnClickListener { view ->
                view.findNavController().navigate(R.id.details_activity)
            }
            with(binding) {
                binding.item = item
                executePendingBindings()
            }
        }

    }
}