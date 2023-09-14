package com.ivanojok.myphotos

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class PhotoAdapter(val context: Context, val photos: List<Photos>): RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {

    class PhotoViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val pic = view.findViewById<ImageView>(R.id.imageView)
        val picText = view.findViewById<TextView>(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false)
        return PhotoViewHolder(v)
    }

    override fun getItemCount(): Int {
        return photos.size
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        Picasso.get().load(photos[position].url).into(holder.pic)
        holder.picText.text = photos[position].title
    }
}