package com.proway.crudizin_basico.utils

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.proway.crudizin_basico.R

fun FragmentActivity.replaceFrag(fragment: Fragment, @IdRes containerId: Int = R.id.container){
    supportFragmentManager.beginTransaction()
        .replace(containerId, fragment)
        .commitNow()
}