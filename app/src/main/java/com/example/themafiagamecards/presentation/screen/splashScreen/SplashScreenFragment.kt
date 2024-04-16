package com.example.themafiagamecards.presentation.screen.splashScreen

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.themafiagamecards.R
import com.example.themafiagamecards.databinding.FragmentSplashScreenBinding
import com.example.themafiagamecards.presentation.common.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SplashScreenFragment : BaseFragment<FragmentSplashScreenBinding>(FragmentSplashScreenBinding::inflate) {
    private val viewModel: SplashViewModel by viewModels()



    override fun bind() {
        goToHome()
    }

    private fun goToHome(){
        lifecycleScope.launch {
            delay(3000)
            findNavController().navigate(R.id.action_splashScreenFragment_to_homeFragment)
        }
    }
}