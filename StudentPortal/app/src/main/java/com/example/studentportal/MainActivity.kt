package com.example.studentportal

import Portal
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {
    private val portals = arrayListOf<Portal>()
    private val portalAdapter = PortalAdapter(portals)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        initViews()

        fabAdd.setOnClickListener {
            onAddClick()
        }
    }

    private fun initViews() {
        rvPortals.layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
        rvPortals.adapter = portalAdapter
        val portal = intent.getParcelableExtra<Portal>(PORTAL_EXTRA)

        if (portal != null) {
//            tvName.text = getString(R.string.name, profile.firstName, profile.lastName)
//            tvDescription.text = profile.description
//            if (profile.imageUri != null) ivProfileImage.setImageURI(profile.imageUri)
            portals.add(Portal(portal.portalTitle, portal.portalUrl))
        }
        portalAdapter.notifyDataSetChanged()
    }

    private fun onAddClick() {
        val profileActivityIntent = Intent(this, CreatePortalActivity::class.java)
        startActivity(profileActivityIntent)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    companion object {
        const val PORTAL_EXTRA = "PORTAL_EXTRA"
    }
}
