package com.muryno.artist.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.muryno.artist.R
import com.muryno.presention.model.ArtistAlbumModel
import com.muryno.presention.model.ArtistModel
import javax.inject.Inject


class ArtistAlbumAdapter @Inject constructor() :
    RecyclerView.Adapter<ArtistAlbumAdapter.MyViewHolder>() {

    private val callback = object : DiffUtil.ItemCallback<ArtistAlbumModel>() {
        override fun areItemsTheSame(
            oldItemNews: ArtistAlbumModel,
            newItemNews: ArtistAlbumModel
        ): Boolean {
            return oldItemNews.id == newItemNews.id
        }

        override fun areContentsTheSame(
            oldItemNews: ArtistAlbumModel,
            newItemNews: ArtistAlbumModel
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

//        private val title: TextView = itemView.findViewById(R.id.txt_title)
//        private val details: TextView = itemView.findViewById(R.id.txt_details)
//        private val txtUrl: TextView = itemView.findViewById(R.id.txt_url)
//        private val language: TextView = itemView.findViewById(R.id.txt_language)
//        private val star: TextView = itemView.findViewById(R.id.txt_star)
//        private val profileImage: ImageView = itemView.findViewById(R.id.profile_image)
//        private val expandLayout: View = itemView.findViewById(R.id.expand_layout)
//

        @SuppressLint("SetTextI18n")
        fun bind(item: ArtistAlbumModel) {
//            title.text = item.name
//            details.text = item.full_name
//            txtUrl.text = item.branches_url
//            language.text = item.language
//            star.text = item.forks.toString()
//            Glide.with(profileImage.context)
//                .load(item.avatar_url)
//                .placeholder(R.drawable.ic_baseline_person_24)
//                .into(profileImage)
//
//            var expand = false
//            itemView.setOnClickListener {
//                expand = !expand
//                if (expand) {
//                    expandLayout.visibility = View.VISIBLE
//                } else {
//                    expandLayout.visibility = View.GONE
//                }
//            }
        }
    }

}