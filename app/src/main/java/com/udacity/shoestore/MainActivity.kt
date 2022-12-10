package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import com.udacity.shoestore.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setContentView(binding.root)
        Timber.plant(Timber.DebugTree())


        setSupportActionBar(binding.toolbar)
        val navcontroller = this.findNavController(R.id.fragment)
        NavigationUI.setupActionBarWithNavController(this,navcontroller)
    }

    override fun onSupportNavigateUp(): Boolean {
        return this.findNavController(R.id.fragment).navigateUp()
    }
}
