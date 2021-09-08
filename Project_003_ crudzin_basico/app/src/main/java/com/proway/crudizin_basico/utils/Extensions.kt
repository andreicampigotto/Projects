package com.proway.crudizin_basico.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.proway.crudizin_basico.R


fun FragmentActivity.replaceFrag(fragment: Fragment) {
    supportFragmentManager.beginTransaction()
        .replace(R.id.container, fragment)
        .commitNow()
}