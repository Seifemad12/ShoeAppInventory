package com.udacity.shoestore.screens.login

import android.annotation.SuppressLint
import android.database.DatabaseUtils
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.inflate
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginScreenBinding
import com.udacity.shoestore.models.bundle
import com.udacity.shoestore.screens.showList.ShoeListViewModel
import timber.log.Timber


class LoginScreen : Fragment() {
    private lateinit var binding: FragmentLoginScreenBinding
    private lateinit var savedStateViewModel:savedStateViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_login_screen, container, false)

        savedStateViewModel=savedStateViewModel()
        savedStateViewModel = ViewModelProvider(this)[savedStateViewModel::class.java]

        binding.newLogin.setOnClickListener {
            if (binding.email.text.isNotEmpty() && binding.password.text.isNotEmpty()) {
                savedStateViewModel.saveInstance(binding.email.text.toString(),binding.password.text.toString())
                findNavController().navigate(R.id.action_loginScreen_to_welcomeScreen)
            } else {
                Toast.makeText(
                    this.activity,
                    " Please fill Email and Password fields",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
        binding.existingLogin.setOnClickListener {
            savedStateViewModel.password.observe(viewLifecycleOwner, Observer {
                if(it.equals(binding.password.text.toString())){
                    findNavController().navigate(R.id.action_loginScreen_to_shoeListScreen)
                }
                else{
                    Toast.makeText(
                        this.activity,
                        " There is no existing account",
                        Toast.LENGTH_LONG
                    ).show()
                }
            })
        }

        return binding.root
    }

}