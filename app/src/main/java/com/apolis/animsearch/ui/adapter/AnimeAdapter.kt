package com.apolis.animsearch.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.apolis.animsearch.R
import com.apolis.animsearch.data.Anime
import com.apolis.animsearch.databinding.ViewHolderAnimeBinding
import com.apolis.animsearch.ui.holders.AnimeViewHolder

class AnimeAdapter(val list: List<Anime>): RecyclerView.Adapter<AnimeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ViewHolderAnimeBinding = DataBindingUtil.inflate(inflater, R.layout.view_holder_anime, parent, false)
        return AnimeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size
}