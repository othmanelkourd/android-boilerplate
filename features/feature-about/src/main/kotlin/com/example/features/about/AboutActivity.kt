package com.example.features.about

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.example.android.utils.AppUtils
import com.example.android.utils.extensions.setToolbar
import de.psdev.licensesdialog.LicensesDialog
import kotlinx.android.synthetic.main.about_activity.*

class AboutActivity : AppCompatActivity() {
  companion object {
    fun newIntent(context: Context): Intent {
      return Intent(context, AboutActivity::class.java)
    }
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.about_activity)

    setToolbar(toolbar, R.string.about_title)

    appVersion.text = AppUtils.getVersionName(applicationContext)

    viewLicenses.setOnClickListener {
      LicensesDialog.Builder(this)
        .setNotices(R.raw.notices)
        .setIncludeOwnLicense(true)
        .setTitle(R.string.licenses)
        .setCloseText(R.string.close)
        .build()
        .show()
    }
  }

  override fun onBackPressed() {
    finish()
    super.onBackPressed()
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    if (item.itemId == android.R.id.home) {
      finish()
      return true
    }

    return super.onOptionsItemSelected(item)
  }
}