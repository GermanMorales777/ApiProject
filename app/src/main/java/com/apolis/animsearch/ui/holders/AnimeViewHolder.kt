package com.apolis.animsearch.ui.holders

import androidx.recyclerview.widget.RecyclerView
import com.apolis.animsearch.data.Anime
import com.apolis.animsearch.databinding.ViewHolderAnimeBinding

class AnimeViewHolder(val binding: ViewHolderAnimeBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(anime: Anime) {
        binding.animeData = anime
    }
}