package com.example.colors

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.colors.adapters.RvAdapter
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var myRv: RecyclerView
    private lateinit var rvAdapter: RvAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val colors = arrayListOf<ArrayList<Int>>()
        myRv = findViewById(R.id.rvMain)
        rvAdapter = RvAdapter(colors)
        myRv.adapter = rvAdapter
        myRv.layoutManager = LinearLayoutManager(this)

        val colorButton = findViewById<Button>(R.id.btColor)
        colorButton.setOnClickListener {
            colors.add(arrayListOf(Random.nextInt(255),Random.nextInt(255),Random.nextInt(255)))
            colorButton.setBackgroundColor(Color.rgb(colors[colors.size-1][0], colors[colors.size-1][1], colors[colors.size-1][2]))
            rvAdapter.setData(colors)
            myRv.scrollToPosition(colors.size-1)
        }
    }
}