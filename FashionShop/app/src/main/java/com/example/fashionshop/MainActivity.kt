package com.example.fashionshop

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private  lateinit var   navHostFragment :NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set up the toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Set up the NavController
         navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        // Set up the AppBarConfiguration with the drawer layout if needed
        appBarConfiguration = AppBarConfiguration(navController.graph)

        // Set up ActionBar with NavController
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)

        // Set custom back arrow drawable
        supportActionBar?.setHomeAsUpIndicator(R.drawable.left_arrow)
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onBackPressed() {
        val fragment = navHostFragment.childFragmentManager.primaryNavigationFragment
        if (fragment is OnBackPressedListener) {
            fragment.onBackPressed()
        } else {
            super.onBackPressed()
        }
    }

}
