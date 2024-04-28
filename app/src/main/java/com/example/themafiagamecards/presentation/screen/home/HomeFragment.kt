package com.example.themafiagamecards.presentation.screen.home

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.themafiagamecards.databinding.FragmentHomeBinding
import com.example.themafiagamecards.presentation.adapter.home_adapter.HomeAdapter
import com.example.themafiagamecards.presentation.common.base.BaseFragment
import com.example.themafiagamecards.presentation.event.home.HomeEvents
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private val viewModel: HomeViewModel by viewModels()
    private lateinit var categoryAdapter: HomeAdapter

    override fun bind() {
        viewModel.get()
        bindAdapter()
    }

    override fun observe() {
        observeUiState()
    }

    override fun listener() {
        adapterListener()
    }

    private fun bindAdapter() {
        categoryAdapter = HomeAdapter()
        binding.rvCategory.layoutManager = LinearLayoutManager(requireContext())
        binding.rvCategory.adapter = categoryAdapter

        categoryAdapter.getData(viewModel.categoryList)
    }

    private fun adapterListener() {
        categoryAdapter.onItemClick(
            category = {
                when (it.title) {
                    "Game" -> {
                        viewModel.onEvent(HomeEvents.GoToGame)
                    }

                    "Roles" -> {
                        viewModel.onEvent(HomeEvents.GoToRoles)
                    }

                    "Rules" -> {
                        viewModel.onEvent(HomeEvents.GoToRules)
                    }
                }
            }
        )
    }

    private fun observeUiState() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect {
                    handleNavigation(it)
                }
            }
        }
    }

    private fun handleNavigation(event: HomeViewModel.NavigationEvent) {
        when (event) {
            is HomeViewModel.NavigationEvent.NavigateToGame -> {
                Toast.makeText(context, "Game", Toast.LENGTH_LONG).show()
            }

            is HomeViewModel.NavigationEvent.NavigateToRoles -> {
                Toast.makeText(context, "Roles", Toast.LENGTH_LONG).show()
            }

            is HomeViewModel.NavigationEvent.NavigateToRules -> {
                Toast.makeText(context, "Rules", Toast.LENGTH_LONG).show()
            }
        }
    }
}