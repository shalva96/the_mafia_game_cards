package com.example.themafiagamecards.presentation.screen.rules

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.themafiagamecards.R
import com.example.themafiagamecards.databinding.FragmentRulesBinding
import com.example.themafiagamecards.presentation.common.base.BaseFragment
import com.example.themafiagamecards.presentation.event.rules.RulesEvent
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RulesFragment : BaseFragment<FragmentRulesBinding>(FragmentRulesBinding::inflate) {

    private val viewModel: RulesViewModel by viewModels()
    override fun bind() {
    }

    override fun observe() {
        observeUiState()
    }

    override fun listener() {
        navigateToHome()
    }

    private fun navigateToHome() {
        binding.root.setOnClickListener {
            viewModel.onEvent(RulesEvent.GoToHome)
        }
    }

    private fun observeUiState() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect {
                    handleUiState(it)
                }
            }
        }

    }

    private fun handleUiState(event: RulesViewModel.NavigationEvent) {
        when (event) {
            is RulesViewModel.NavigationEvent.NavigateToHome -> {
                findNavController().navigate(RulesFragmentDirections.actionRulesFragmentToHomeFragment())
            }
        }
    }

}