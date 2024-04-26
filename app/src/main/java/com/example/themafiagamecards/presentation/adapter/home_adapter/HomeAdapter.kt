package com.example.themafiagamecards.presentation.adapter.home_adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.themafiagamecards.databinding.RecyclerHomeBinding
import com.example.themafiagamecards.presentation.model.home_category.Category

class HomeAdapter: RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {
    private var categoryList = emptyList<Category>()
   inner class HomeViewHolder(private val binding:RecyclerHomeBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(item:Category) {
            binding.buttonItem.text = item.title
            binding.buttonItem.setCompoundDrawablesWithIntrinsicBounds(item.icon,0,0,0)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RecyclerHomeBinding.inflate(inflater,parent,false)
        return HomeViewHolder(binding)

    }

    override fun getItemCount(): Int = categoryList.size

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(item = categoryList[position])

    }

    fun getData(newList:List<Category>){
        categoryList = newList
        notifyItemChanged(categoryList.size)
    }
}