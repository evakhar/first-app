package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.appbar.MaterialToolbar
import android.util.Log
import android.widget.Adapter
import android.widget.ListView
import android.widget.ProgressBar
import android.widget.SimpleAdapter
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"

    lateinit var requestInput: TextInputEditText

    lateinit var progressBar: ProgressBar

    lateinit var podsAdapter: SimpleAdapter

    val pods = mutableListOf<HashMap<String, String>>(
        HashMap<String, String>().apply { this; HashMap<String, String>
            put("Title", "Test title")
            put("Content", "Test Content")
        }
    )

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }
    fun initViews() {
        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
              setSupportActionBar(toolbar)

              requestInput = findViewById<TextInputEditText>(R.id.text_input_edit)
              progressBar = findViewById<ProgressBar>(R.id.progress_bar)
              val podsList = findViewById<ListView>(R.id.pods_list)
              podsAdapter = SimpleAdapter (
                  applicationContext,
                  pods,
                  R.layout.item_pod,
                  arrayOf("Title", "Content"),
                  intArrayOf(R.id.title, R.id.content)

                      )
        podsList.adapter = podsAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
       menuInflater.inflate(R.menu.toolbar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.action_search -> {
              Log.d(TAG, "action_search")
                return true
            }
            R.id.action_clear -> {

            }
            else -> return super.onOptionsItemSelected(item)
        }

        return super.onOptionsItemSelected(item)
    }
}