package com.example.themafiagamecards.presentation.screen.home

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.themafiagamecards.databinding.FragmentHomeBinding
import com.example.themafiagamecards.presentation.adapter.home_adapter.HomeAdapter
import com.example.themafiagamecards.presentation.common.base.BaseFragment
import com.example.themafiagamecards.presentation.event.home.HomeEvents
import com.example.themafiagamecards.presentation.screen.state.home.HomeState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private val viewModel: HomeViewModel by viewModels()
    private lateinit var categoryAdapter: HomeAdapter

    override fun bind() {
        bindAdapter()
    }

    override fun observe() {
        observeState()
        observeUiState()
    }

    override fun listener() {
        adapterListener()
    }

    private fun bindAdapter() {
        categoryAdapter = HomeAdapter()
        binding.rvCategory.layoutManager = LinearLayoutManager(requireContext())
        binding.rvCategory.adapter = categoryAdapter
    }


    private fun adapterListener() {
        categoryAdapter.onItemClick(category = {
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
        })
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

    private fun observeState() {
        viewModel.onEvent(HomeEvents.GetCategoryList)
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.homeState.collect {
                    handleState(it)
                }
            }
        }

    }

    private fun handleState(state: HomeState) {
        state.button?.let {
            categoryAdapter.getData(it)
        }
    }

    private fun handleNavigation(event: HomeViewModel.NavigationEvent) {
        when (event) {
            is HomeViewModel.NavigationEvent.NavigateToGame -> {
                findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToGameFragment())
            }

            is HomeViewModel.NavigationEvent.NavigateToRoles -> {
                findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToRolesFragment())
            }

            is HomeViewModel.NavigationEvent.NavigateToRules -> {
                findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToRulesFragment())
            }
        }
    }
}