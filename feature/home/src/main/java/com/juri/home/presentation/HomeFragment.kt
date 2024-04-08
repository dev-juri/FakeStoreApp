package com.juri.home.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.juri.core.repositories.StoreRepository
import com.juri.home.R
import com.juri.home.di.inject
import kotlinx.coroutines.runBlocking
import javax.inject.Inject


class HomeFragment : Fragment() {

    @Inject
    lateinit var storeRepo: StoreRepository


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        runBlocking {
            storeRepo.fetchRemoteProducts()

            storeRepo.getSavedProducts().observe(viewLifecycleOwner) {
                Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_LONG).show()
            }
        }
    }


}