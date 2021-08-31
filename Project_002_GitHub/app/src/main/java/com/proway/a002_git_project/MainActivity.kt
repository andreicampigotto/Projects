package com.proway.a002_git_project

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.proway.a002_git_project.view.RepositoryFragment
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, RepositoryFragment.newInstance())
                .commitNow()
    }
}