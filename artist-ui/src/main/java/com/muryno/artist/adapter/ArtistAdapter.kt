package com.muryno.artist.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.muryno.artist.R
import com.muryno.presention.artist.model.ArtistPresentationModel
import javax.inject.Inject


class ArtistAdapter @Inject constructor() :
    RecyclerView.Adapter<ArtistAdapter.MyViewHolder>() {

    lateinit var clickedArtist: (ArtistPresentationModel) -> Unit

    private val callback = object : DiffUtil.ItemCallback<ArtistPresentationModel>() {
        override fun areItemsTheSame(
            oldItemNews: ArtistPresentationModel,
            newItemNews: ArtistPresentationModel
        ): Boolean {
            return oldItemNews.id == newItemNews.id
        }

        override fun areContentsTheSame(
            oldItemNews: ArtistPresentationModel,
            newItemNews: ArtistPresentationModel
        ): Boolean {
            return oldItemNews == newItemNews
        }

    }

    var differ = AsyncListDiffer(this, callback)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val bindingView: View = layoutInflater.inflate(
            R.layout.list_item,
            parent,
            false
        )
        return MyViewHolder(bindingView, clickedArtist)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val trendingGithubUserItem = differ.currentList[position]
        holder.bind(trendingGithubUserItem)
    }


    class MyViewHolder(itemView: View, val clickedArtist: (ArtistPresentationModel) -> Unit) :
        RecyclerView.ViewHolder(itemView) {

        private val txtName: TextView = itemView.findViewById(R.id.txt_name)
        private val txtCity: TextView = itemView.findViewById(R.id.txt_city)
        private val txtGender: TextView = itemView.findViewById(R.id.txt_gender)
        private val txtDescriptionLabel: TextView =
            itemView.findViewById(R.id.txt_description_label)

        @SuppressLint("SetTextI18n")
        fun bind(item: ArtistPresentationModel) {
            txtName.text = item.name
            txtCity.text = item.city
            txtGender.text = item.gender
            txtDescriptionLabel.text = item.description

            itemView.setOnClickListener {
                clickedArtist(item)
            }
        }
    }

}