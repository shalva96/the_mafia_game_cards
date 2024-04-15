package com.example.themafiagamecards.presentation.screen.home

import androidx.fragment.app.viewModels
import com.example.themafiagamecards.databinding.FragmentHomeBinding
import com.example.themafiagamecards.presentation.common.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private val viewModel: HomeViewModel by viewModels()

    override fun bind() {
        viewModel.get()
    }

}