package com.udacity.shoestore.screens.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginScreenBinding
import com.udacity.shoestore.databinding.FragmentWelcomeScreenBinding


class WelcomeScreen : Fragment() {
    private lateinit var binding: FragmentWelcomeScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_welcome_screen, container, false)

        binding.startApp.setOnClickListener {
            findNavController().navigate(R.id.action_welcomeScreen_to_instructionScreen)
        }
        return binding.root
    }


}