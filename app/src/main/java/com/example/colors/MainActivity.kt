package com.example.colors

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.colors.adapters.RvAdapter
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var myRv: RecyclerView
    private lateinit var rvAdapter: RvAdapter
    lateinit var llMain: LinearLayout
    public var bg = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        llMain = findViewById(R.id.llMain)

        val colors = arrayListOf<ArrayList<Int>>()
        myRv = findViewById(R.id.rvMain)
        rvAdapter = RvAdapter(colors, this)
        myRv.adapter = rvAdapter
        myRv.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)

        val colorButton = findViewById<Button>(R.id.btColor)
        colorButton.setOnClickListener {
            colors.add(arrayListOf(Random.nextInt(255),Random.nextInt(255),Random.nextInt(255)))
            colorButton.setBackgroundColor(Color.rgb(colors[colors.size-1][0], colors[colors.size-1][1], colors[colors.size-1][2]))
            rvAdapter.setData(colors)
            myRv.scrollToPosition(colors.size-1)
        }
    }
}