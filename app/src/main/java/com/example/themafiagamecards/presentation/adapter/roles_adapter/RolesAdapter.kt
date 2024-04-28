package com.example.themafiagamecards.presentation.adapter.roles_adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.themafiagamecards.databinding.RecyclerHomeBinding
import com.example.themafiagamecards.databinding.RecyclerRolesBinding
import com.example.themafiagamecards.presentation.model.Role
import com.example.themafiagamecards.presentation.model.home_category.Category

class RolesAdapter: RecyclerView.Adapter<RolesAdapter.RolesViewHolder>() {
    private var rolesList = emptyList<Role>()
    inner class RolesViewHolder(private val binding: RecyclerRolesBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(item: Role){
            binding.buttonItem.text =item.role
            binding.buttonItem.setCompoundDrawablesWithIntrinsicBounds(item.color,0,0,0)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RolesViewHolder {
        return RolesViewHolder(
            RecyclerRolesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = rolesList.size

    override fun onBindViewHolder(holder: RolesViewHolder, position: Int) {
        holder.bind(item = rolesList[position])
    }
    fun getData(newList:List<Role>){
        rolesList = newList
        notifyItemChanged(rolesList.size)
    }
}