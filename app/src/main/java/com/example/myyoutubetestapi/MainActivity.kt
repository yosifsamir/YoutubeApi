package com.example.myyoutubetestapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.SparseArray
import android.view.Menu
import android.view.MenuItem
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import com.example.myyoutubetestapi.fragment.HomeFragment
import com.example.myyoutubetestapi.fragment.PlaylistFragment
import com.example.myyoutubetestapi.fragment.ProfileFragment
import com.example.myyoutubetestapi.fragment.SearchFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    var homeFragment=HomeFragment()
    var searchFragment=SearchFragment()
    var profileFragment=ProfileFragment()
    var playListFragment=PlaylistFragment()

    var bottomNavigationView:BottomNavigationView ? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView=findViewById(R.id.bottomNavigationView)
        showFragment(homeFragment)

        bottomNavigationView!!.setOnNavigationItemSelectedListener(object :
            BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                if(item.itemId==R.id.menu_home){
                    showFragment(homeFragment)
                }
                else if(item.itemId==R.id.menu_search){
                    showFragment(searchFragment)
                }
                else if(item.itemId==R.id.menu_play_list) {
                    showFragment(playListFragment)
                }
                else if(item.itemId==R.id.menu_profile){
                    showFragment(profileFragment)
                }

                return true
            }

        })

    }

    private fun showFragment(fragment: Fragment) {
        var fragmentManager=supportFragmentManager
        var fragmentTransaction=fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.main_frame,fragment)
        fragmentTransaction.commit()
    }




    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)
    }
}
