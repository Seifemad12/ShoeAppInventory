package com.udacity.shoestore.screens.instructions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionScreenBinding
import com.udacity.shoestore.databinding.FragmentWelcomeScreenBinding


class InstructionScreen : Fragment() {
    private lateinit var binding: FragmentInstructionScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_instruction_screen, container, false)
        binding.toShoeList.setOnClickListener {
            findNavController().navigate(R.id.action_instructionScreen_to_shoeListScreen)
        }
        return binding.root
    }

}