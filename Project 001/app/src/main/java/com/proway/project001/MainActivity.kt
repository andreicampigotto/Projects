package com.proway.project001

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.proway.project001.fragments.BeerFragment
import com.proway.project001.fragments.DrinkFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        findViewById<BottomNavigationView>(R.id.bottom_navigation).apply {
            setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.drink -> {
                        replaceFrag(DrinkFragment())
                        true
                    }
                    R.id.beer -> {
                        replaceFrag(BeerFragment())
                        true
                    }
                    else -> false
                }
            }
        }
    }


    private fun replaceFrag(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commitNow()
    }
}