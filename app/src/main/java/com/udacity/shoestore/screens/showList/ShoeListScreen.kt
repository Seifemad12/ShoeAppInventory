package com.udacity.shoestore.screens.showList

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.children
import androidx.core.view.updatePadding
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginScreenBinding
import com.udacity.shoestore.databinding.FragmentShoeListScreenBinding
import com.udacity.shoestore.models.Shoe
import kotlinx.android.synthetic.main.fragment_welcome_screen.view.*


class ShoeListScreen : Fragment() {

    private lateinit var binding: FragmentShoeListScreenBinding
    lateinit var viewModel: ShoeListViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(layoutInflater,R.layout.fragment_shoe_list_screen, container, false)


        viewModel = ViewModelProvider(this)[ShoeListViewModel::class.java]

        viewModel.shoeList.observe(viewLifecycleOwner, Observer {
            for(i in it){
                binding.linearLayout.addView(createNewItem(i))
            }
        })

        binding.toDetail.setOnClickListener {
            findNavController().navigate(R.id.action_shoeListScreen_to_detailsScreen)
        }
        setHasOptionsMenu(true)

        return binding.root
    }

    private fun createNewItem(i:Shoe):TextView {
        val mtextview = TextView(this.activity)
        mtextview.setText(i.name+" with size "+i.size +" at "+i.company+": "+i.description)
        mtextview.setTextSize(25f)
        mtextview.updatePadding(left = 30, bottom = 30)
        return mtextview
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.my_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.backtoLogin->{findNavController().navigate(R.id.action_shoeListScreen_to_loginScreen)}
        }
        return super.onOptionsItemSelected(item)
        /*return NavigationUI.onNavDestinationSelected(item,requireView().findNavController())
                ||super.onOptionsItemSelected(item)*/
    }

}