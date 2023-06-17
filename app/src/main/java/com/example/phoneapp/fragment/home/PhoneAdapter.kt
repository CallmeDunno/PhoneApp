package com.example.phoneapp.fragment.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.phoneapp.databinding.ItemListBinding
import com.example.phoneapp.room.PhoneNumber

class PhoneAdapter(diffCallback: DiffUtil.ItemCallback<PhoneNumber>) :
    ListAdapter<PhoneNumber, PhoneAdapter.PhoneVH>(diffCallback) {

    class PhoneVH(itemBinding : ItemListBinding) : RecyclerView.ViewHolder(itemBinding.root){
        var itemBinding: ItemListBinding? = null
        init {
            this.itemBinding = itemBinding
        }
        fun bindData(phoneNumber: PhoneNumber){
            itemBinding!!.apply {
                tvName.text = phoneNumber.name
                tvNumberphone.text = phoneNumber.phoneNumber
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhoneVH {
        val itemBinding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhoneVH(itemBinding)
    }

    override fun onBindViewHolder(holder: PhoneVH, position: Int) {
        if (getItem(position) == null){
            return
        }
        holder.bindData(getItem(position))
    }

}