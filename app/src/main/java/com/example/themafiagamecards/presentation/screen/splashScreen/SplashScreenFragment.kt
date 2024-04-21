package com.example.themafiagamecards.presentation.screen.splashScreen

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.themafiagamecards.R
import com.example.themafiagamecards.databinding.FragmentSplashScreenBinding
import com.example.themafiagamecards.presentation.common.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SplashScreenFragment : BaseFragment<FragmentSplashScreenBinding>(FragmentSplashScreenBinding::inflate) {
    private val viewModel: SplashViewModel by viewModels()

    override fun bind() {
        viewModel.navigationDuration()
    }

    override fun observe() {
        viewLifecycleOwner.lifecycleScope.launch{
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.uiEvent.collect{
                    handleNavigationEvent(it)
                }
            }
        }
    }
    private fun handleNavigationEvent(event:SplashViewModel.SplashUiEvent){
        when(event){
            is SplashViewModel.SplashUiEvent.NavigateToHome -> {
                findNavController().navigate(SplashScreenFragmentDirections.actionSplashScreenFragmentToHomeFragment())

            }
        }
    }
}