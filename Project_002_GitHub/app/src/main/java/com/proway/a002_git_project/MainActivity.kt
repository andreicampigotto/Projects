package com.proway.a002_git_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.proway.a002_git_project.view.RepositoryFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, RepositoryFragment.newInstance())
                .commitNow()
        }
    }
}