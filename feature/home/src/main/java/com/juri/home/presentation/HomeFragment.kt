package com.juri.home.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.juri.home.adapter.StoreAdapter
import com.juri.home.databinding.FragmentHomeBinding
import com.juri.home.di.inject
import com.juri.home.viewModel.HomeViewModel
import com.juri.home.viewModel.NetworkState


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: StoreAdapter

    private val viewModel by viewModels<HomeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = StoreAdapter()
        binding.productsRecycler.adapter = adapter

        viewModel.products.observe(viewLifecycleOwner) {
            if (it.isNotEmpty()) {
                adapter.submitList(it.toList())
            }
        }

        viewModel.status.observe(viewLifecycleOwner) {
            if (it != null) {
                when (it) {
                    NetworkState.SUCCESS -> {}
                    NetworkState.ERROR -> {}
                    else -> {}
                }
            }
        }
    }


}