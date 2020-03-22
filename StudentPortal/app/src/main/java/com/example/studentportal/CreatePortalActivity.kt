package com.example.studentportal

import Portal
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_create_portal.*

class CreatePortalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_portal)

        initViews()
    }

    private fun initViews() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.portal_create_top_bar)

        btnAddPortal.setOnClickListener{
            onAddPortalClick()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    private fun onAddPortalClick() {
        val portal = Portal(
            etTitle.text.toString(),
            etURL.text.toString()
        )

        val profileActivityIntent = Intent(this, MainActivity::class.java)
        profileActivityIntent.putExtra(MainActivity.PORTAL_EXTRA, portal)
        startActivity(profileActivityIntent)
    }
}