package com.example.themafiagamecards.presentation.screen.roles

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.themafiagamecards.databinding.FragmentRolesBinding
import com.example.themafiagamecards.presentation.adapter.roles_adapter.RolesAdapter
import com.example.themafiagamecards.presentation.common.base.BaseFragment
import com.example.themafiagamecards.presentation.event.roles.RolesEvent
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RolesFragment : BaseFragment<FragmentRolesBinding>(FragmentRolesBinding::inflate) {
   private lateinit var rolesAdapter: RolesAdapter
   private val viewModel:RolesViewModel by viewModels()
    override fun bind() {
        bindAdapter()

    }

    override fun observe() {
        observeUiState()
    }

    override fun listener() {
        navigationToBack()
    }
    private fun observeUiState(){
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.uiState.collect{
                    handleUiState(it)
                }
            }
        }
    }
    private fun navigationToBack(){
        binding.ivBackArr.setOnClickListener {
            viewModel.onEvent(RolesEvent.GoToHome)
        }
    }

    private fun bindAdapter(){
        rolesAdapter = RolesAdapter()
        binding.rvRoles.layoutManager = LinearLayoutManager(requireContext())
        binding.rvRoles.adapter = rolesAdapter
    }

    private fun handleUiState(event: RolesViewModel.NavigationEvent){
        when(event) {
            is RolesViewModel.NavigationEvent.NavigateToHome -> {
                findNavController().navigate(RolesFragmentDirections.actionRolesFragmentToHomeFragment())
            }
        }
    }

}