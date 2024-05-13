package com.example.themafiagamecards.presentation.adapter.roles_adapter

import android.content.res.ColorStateList
import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.themafiagamecards.R
import com.example.themafiagamecards.databinding.RecyclerHomeBinding
import com.example.themafiagamecards.databinding.RecyclerRolesBinding
import com.example.themafiagamecards.presentation.model.Role
import com.example.themafiagamecards.presentation.model.home_category.Category

class RolesAdapter : RecyclerView.Adapter<RolesAdapter.RolesViewHolder>() {
    private var rolesList = emptyList<Role>()

    inner class RolesViewHolder(private val binding: RecyclerRolesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Role) {
            binding.buttonItem.text = item.role

            val drawable =
                ContextCompat.getDrawable(binding.root.context, R.drawable.ic_purple_circle)
                    ?.mutate()
            drawable?.let {
                val wrappedDrawable = DrawableCompat.wrap(it)
                DrawableCompat.setTint(
                    wrappedDrawable,
                    binding.root.context.resources.getColor(item.color)
                )
                DrawableCompat.setTintMode(wrappedDrawable, PorterDuff.Mode.SRC_IN)
                binding.buttonItem.setCompoundDrawablesWithIntrinsicBounds(
                    wrappedDrawable,
                    null,
                    null,
                    null
                )
            }
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

    fun getData(newList: List<Role>) {
        rolesList = newList
        notifyItemChanged(rolesList.size)
    }
}