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
import com.muryno.presention.artistAlbulm.model.ArtistAlbumPresentationModel
import javax.inject.Inject


class ArtistAlbumAdapter @Inject constructor() :
    RecyclerView.Adapter<ArtistAlbumAdapter.MyViewHolder>() {

    private val callback = object : DiffUtil.ItemCallback<ArtistAlbumPresentationModel>() {
        override fun areItemsTheSame(
            oldItemNews: ArtistAlbumPresentationModel,
            newItemNews: ArtistAlbumPresentationModel
        ): Boolean {
            return oldItemNews.id == newItemNews.id
        }

        override fun areContentsTheSame(
            oldItemNews: ArtistAlbumPresentationModel,
            newItemNews: ArtistAlbumPresentationModel
        ): Boolean {
            return oldItemNews == newItemNews
        }

    }

    var differ = AsyncListDiffer(this, callback)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val bindingView: View = layoutInflater.inflate(
            R.layout.list_details_item,
            parent,
            false
        )
        return MyViewHolder(bindingView)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val trendingGithubUserItem = differ.currentList[position]
        holder.bind(trendingGithubUserItem)
    }


    class MyViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        private val txtName: TextView = itemView.findViewById(R.id.txt_name)
        private val txtReleaseDate: TextView = itemView.findViewById(R.id.txt_release_date)
        private val txtGender: TextView = itemView.findViewById(R.id.txt_primary)
        private val txtDescriptionLabel: TextView = itemView.findViewById(R.id.txt_about_label)

        @SuppressLint("SetTextI18n")
        fun bind(item: ArtistAlbumPresentationModel) {
            txtName.text = item.title
            txtReleaseDate.text = item.releaseDate
            txtGender.text = item.primaryType
            txtDescriptionLabel.text = item.disambiguation

        }
    }

}