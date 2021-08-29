package com.proway.a002_git_project.utils

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.proway.a002_git_project.R

fun FragmentActivity.replaceView(fragement:Fragment, @IdRes containerId: Int = R.id.container){
    supportFragmentManager.beginTransaction()
        .replace(containerId, fragement)
        .commitNow()
}