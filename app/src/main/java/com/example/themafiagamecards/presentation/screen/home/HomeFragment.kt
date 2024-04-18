package com.example.themafiagamecards.presentation.screen.home

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.themafiagamecards.databinding.FragmentHomeBinding
import com.example.themafiagamecards.presentation.adapter.home_adapter.HomeAdapter
import com.example.themafiagamecards.presentation.common.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private val viewModel: HomeViewModel by viewModels()
    private lateinit var categoryAdapter:HomeAdapter

    override fun bind() {
        viewModel.get()
        bindAdapter()
    }

    private fun bindAdapter(){
        categoryAdapter = HomeAdapter()
        binding.rvCategory.layoutManager = LinearLayoutManager(requireContext())
        binding.rvCategory.adapter = categoryAdapter

        categoryAdapter.getData(viewModel.categoryList)
    }
}