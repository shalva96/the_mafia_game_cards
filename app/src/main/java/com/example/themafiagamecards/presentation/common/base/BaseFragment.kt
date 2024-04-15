package com.example.themafiagamecards.presentation.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

typealias Inflate<VB> = (LayoutInflater, ViewGroup?, Boolean) -> VB
abstract class BaseFragment<VB: ViewBinding>(private val inflate: Inflate<VB>) : Fragment()  {

    private var _binding: VB? = null
    protected val binding: VB get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = inflate.invoke(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()
        event()
        observe()
        listener()
    }

    abstract fun bind()
    open fun listener() {}
    open fun observe() {}
    open fun event() {}


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}