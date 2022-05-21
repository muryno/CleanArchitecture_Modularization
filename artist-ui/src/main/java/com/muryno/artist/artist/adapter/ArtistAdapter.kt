package com.muryno.artist.artist.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.muryno.artist.R
import com.muryno.artist.artist.model.ArtistUIModel
class ArtistAdapter:
    RecyclerView.Adapter<ArtistAdapter.MyViewHolder>() {

    lateinit var mClickedArtist: (ArtistUIModel) -> Unit
    private val callback = object : DiffUtil.ItemCallback<ArtistUIModel>() {
        override fun areItemsTheSame(
            oldItemNews: ArtistUIModel,
            newItemNews: ArtistUIModel
        ): Boolean {
            return oldItemNews.id == newItemNews.id
        }
        override fun areContentsTheSame(
            oldItemNews: ArtistUIModel,
            newItemNews: ArtistUIModel
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
        return MyViewHolder(bindingView, mClickedArtist)
    }
    override fun getItemCount(): Int {
        return differ.currentList.size
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val trendingGithubUserItem = differ.currentList[position]
        holder.bind(trendingGithubUserItem)
    }
    class MyViewHolder(itemView: View, val clickedArtist: (ArtistUIModel) -> Unit) :
        RecyclerView.ViewHolder(itemView) {

        private val txtName: TextView  by lazy { itemView.findViewById(R.id.txt_name) }

        private val txtCity: TextView by lazy { itemView.findViewById(R.id.txt_city) }

        private val txtCountry: TextView by lazy { itemView.findViewById(R.id.txt_country) }

        private val txtGender: TextView by lazy { itemView.findViewById(R.id.txt_gender) }

        private val txtDescriptionLabel: TextView by lazy { itemView.findViewById(R.id.txt_description_label) }

        @SuppressLint("SetTextI18n")
        fun bind(item: ArtistUIModel) {
            txtName.text = item.name

            txtCity.text = item.city

            txtGender.text = item.gender
            
            txtCountry.text = item.country
            txtDescriptionLabel.text = item.description
            itemView.setOnClickListener {
                clickedArtist(item)
            }
        }
    }
}