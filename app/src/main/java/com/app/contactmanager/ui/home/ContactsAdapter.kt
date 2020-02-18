package com.app.contactmanager.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.contactmanager.data.remote.response.ContactResponse
import com.app.contactmanager.databinding.ItemContactBinding

class ContactsAdapter(private val list: List<ContactResponse.Contact>) :
    RecyclerView.Adapter<ContactsAdapter.ContactHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ContactHolder(ItemContactBinding.inflate(LayoutInflater.from(parent.context)))

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ContactHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class ContactHolder(private val binding: ItemContactBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(contact: ContactResponse.Contact) {
            binding.tvPersonName.text = contact.name.fullName
        }
    }
}