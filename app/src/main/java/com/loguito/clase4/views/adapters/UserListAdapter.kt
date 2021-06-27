package com.loguito.clase4.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.loguito.clase4.R
import com.loguito.clase4.views.models.UserInformation

// TODO 5: Implementamos el adapter para pintar el recyclerview
class UserListAdapter(val onItemClicked: ((UserInformation) -> (Unit))? = null) : RecyclerView.Adapter<UserListAdapter.UserViewHolder>() {

    // TODO 6: Definimos la lista de usuarios
    var userList: List<UserInformation> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    //    TODO 4: Creamos el ViewHolder, encargado de pintar y escuchar clicks de cada celda
    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        private var emailTextView: TextView = itemView.findViewById(R.id.emailTextView)
        private var userImageView: ImageView = itemView.findViewById(R.id.userIconImageView)

        fun bind(model: UserInformation) {
            // TODO 11: Definimos el click listener para la celda
            itemView.setOnClickListener { onItemClicked?.invoke(model) }

            // TODO 12: Llenamos los campos de la celda
            nameTextView.text = model.name
            emailTextView.text = model.email
            Glide.with(itemView.context).load(model.imageUrl).transform(CircleCrop()).into(userImageView)
//            Picasso.get().load(model.imageUrl).into(userImageView)
        }
    }

    // TODO 8: Inflamos la vista de la celda y la pasamos al ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val holderView = LayoutInflater.from(parent.context).inflate(R.layout.item_user_cell, parent, false)
        return UserViewHolder(holderView)
    }

    // TODO 9: Pintamos la informacion de la celda, para cada posicion
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(userList[position])
    }

    // TODO 7: Devolvemos el tamano de la lista
    override fun getItemCount(): Int = userList.size
}