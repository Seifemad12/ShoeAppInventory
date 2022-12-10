package com.udacity.shoestore.screens.details

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentDetailsScreenBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.arrayOfShoes
import com.udacity.shoestore.screens.showList.ShoeListViewModel

class DetailsScreen : Fragment() {
    lateinit var binding: FragmentDetailsScreenBinding
    private val shoes:Shoe =Shoe("","","","", listOf())
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_details_screen,container,false)
        binding.shoes = shoes
        binding.nav = this
        binding.lifecycleOwner = this
        binding.shoeListViewModel = ShoeListViewModel()


        return binding.root
    }

    fun navigateback(){
        findNavController().navigate(R.id.action_detailsScreen_to_shoeListScreen)
    }

}