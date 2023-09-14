package com.ivanojok.myphotos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.IO).launch {
            val retrofit = RetrofitInstance()
            val service = retrofit.initialiseService()
            val photos = service.getPhotos()

            withContext(Dispatchers.Main) {
                val recyclerView = findViewById<RecyclerView>(R.id.myView)
                val adapter = PhotoAdapter(this@MainActivity, photos)
                recyclerView.adapter = adapter
                recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                //recyclerView.layoutManager = GridLayoutManager(this@MainActivity, 2)
            }

        }
    }
}