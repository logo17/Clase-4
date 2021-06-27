package com.loguito.clase4.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.loguito.clase4.R

class UserHeaderAdapter(val letterHeader: String) : RecyclerView.Adapter<UserHeaderAdapter.UserHeaderViewHolder>() {
    inner class UserHeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val headerTextView: TextView = itemView.findViewById(R.id.headerTextView)
        fun bind(letter: String) {
            headerTextView.text = letter
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHeaderViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user_header_cell, parent, false)
        return UserHeaderViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserHeaderViewHolder, position: Int) {
        holder.bind(letterHeader)
    }

    override fun getItemCount(): Int = 1
}