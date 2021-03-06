package com.example.roomy

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.databinding.DataBindingUtil
import com.example.roomy.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        Timber.v( "calling onCreate" )
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main )

        val navController = findNavController( R.id.nav_host_fragment )

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications ) )

        setupActionBarWithNavController( navController, appBarConfiguration )

        binding.navView.setupWithNavController( navController )
    }
}