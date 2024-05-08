package com.example.themafiagamecards.presentation.screen.game

import android.os.Bundle
import android.util.Log.d
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
import com.example.themafiagamecards.databinding.FragmentGameBinding
import com.example.themafiagamecards.presentation.common.base.BaseFragment
import com.example.themafiagamecards.presentation.event.game.GameEvent
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class GameFragment : BaseFragment<FragmentGameBinding>(FragmentGameBinding::inflate) {
    private val viewModel:GameViewModel by viewModels()
    override fun bind() {
    }
    override fun observe() {
        observeUiState()
    }
    override fun listener() {
            binding.root.setOnClickListener {
                viewModel.onEvent(GameEvent.GoToHome)
            }
    }

    private fun observeUiState(){
        viewLifecycleOwner.lifecycleScope.launch{
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.uiState.collect{
                    handleUiState(it)
                }
            }
        }
    }
    private fun handleUiState(event:GameViewModel.NavigationEvent){
        when(event){
            is GameViewModel.NavigationEvent.NavigationToHome ->{
                findNavController().navigate(GameFragmentDirections.actionGameFragmentToHomeFragment())
            }
        }
    }
}