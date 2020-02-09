package com.chjaeggi.boardgametracker.charts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.chjaeggi.boardgametracker.R
import com.chjaeggi.boardgametracker.databinding.ListItemGameBinding
import com.chjaeggi.boardgametracker.details.DetailsActivity
import com.chjaeggi.boardgametracker.domain.BoardGame

class GamesAdapter : RecyclerView.Adapter<GamesAdapter.ViewHolder>() {

    private var items: List<GamesAdapterModel> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemGameBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position])

    override fun getItemCount(): Int = items.size

    fun replaceData(list: List<BoardGame>) {
        items = list.mapIndexed { index, boardGame ->
            val playersString =
                if (boardGame.minPlayers == boardGame.maxPlayers) {
                    boardGame.minPlayers.toString()
                } else {
                    boardGame.minPlayers.toString() + " - " + boardGame.maxPlayers.toString()
                }
            GamesAdapterModel(
                boardGame.id,
                boardGame.name,
                boardGame.thumbnailUrl,
                (index + 1).toString(),
                boardGame.playTime.toString(),
                playersString
            )
        }
        notifyDataSetChanged()
    }

    inner class ViewHolder(val binding: ListItemGameBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: GamesAdapterModel) {
            binding.root.setOnClickListener { view ->
                view.findNavController()
                    .navigate(R.id.details_activity, DetailsActivity.bundleArgs(model.id))
            }
            with(binding) {
                binding.model = model
                executePendingBindings()
            }
        }


    }
}