package com.example.studentportal

import Portal
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
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
//        val portal = Portal(
//            etTitle.text.toString(),
//            etURL.text.toString()
//        )
//
//        val portalActivityIntent = Intent(this, MainActivity::class.java)
//        portalActivityIntent.putExtra(MainActivity.PORTAL_EXTRA, portal)
//        startActivity(portalActivityIntent)

        if (etTitle.text.toString().isNotBlank() && etURL.text.toString().isNotBlank()) {
            val portal = Portal(
                etTitle.text.toString(),
                etURL.text.toString()
            )
            var resultIntent = Intent()
            resultIntent.putExtra(PORTAL_EXTRA, portal)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        } else {
            Toast.makeText(this,"The fields cannot be empty"
                , Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        const val PORTAL_EXTRA = "PORTAL_EXTRA"
    }
}