package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentWelcomeScreenBinding

class WelcomeScreen : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentWelcomeScreenBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_welcome_screen, container, false)

        binding.buttonToInstructions.setOnClickListener{
            findNavController().navigate(WelcomeScreenDirections.actionWelcomeScreenToInstructions())
        }
        setHasOptionsMenu(true)
        return binding.root
    }
}