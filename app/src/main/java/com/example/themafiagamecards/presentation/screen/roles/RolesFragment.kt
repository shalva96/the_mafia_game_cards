package com.example.themafiagamecards.presentation.screen.roles

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.themafiagamecards.R
import com.example.themafiagamecards.databinding.FragmentRolesBinding
import com.example.themafiagamecards.presentation.adapter.roles_adapter.RolesAdapter
import com.example.themafiagamecards.presentation.common.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RolesFragment : BaseFragment<FragmentRolesBinding>(FragmentRolesBinding::inflate) {
   private lateinit var rolesAdapter: RolesAdapter
   private val viewModel:RolesViewModel by viewModels()
    override fun bind() {
        bindAdapter()
    }

    private fun bindAdapter(){
        rolesAdapter = RolesAdapter()
        binding.rvRoles.layoutManager = LinearLayoutManager(requireContext())
        binding.rvRoles.adapter = rolesAdapter
    }
}