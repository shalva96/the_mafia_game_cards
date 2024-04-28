package com.example.themafiagamecards.presentation.screen.splashScreen

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.themafiagamecards.databinding.FragmentSplashScreenBinding
import com.example.themafiagamecards.presentation.common.base.BaseFragment
import com.example.themafiagamecards.presentation.event.SplashEvent
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SplashScreenFragment : BaseFragment<FragmentSplashScreenBinding>(FragmentSplashScreenBinding::inflate) {
    private val viewModel: SplashViewModel by viewModels()

    override fun bind() {

    }

    override fun observe() {
        viewLifecycleOwner.lifecycleScope.launch {
            delay(2000)
            viewModel.onEvent(SplashEvent.NavigateToMain)
        }
        navigationObserve()
    }

    private fun navigationObserve(){
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.uiState.collect {
                    navigateToHome(it)
                }
            }
        }
    }

    private fun navigateToHome(event: SplashViewModel.SplashUiEvent){
        when(event){
            is SplashViewModel.SplashUiEvent.NavigationToHome -> {
                findNavController().navigate(SplashScreenFragmentDirections.actionSplashScreenFragmentToHomeFragment())
            }
        }
    }

}