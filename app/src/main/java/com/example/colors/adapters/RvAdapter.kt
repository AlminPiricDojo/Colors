package com.example.colors.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.colors.MainActivity
import com.example.colors.databinding.ColorItemBinding

class RvAdapter(private var colors: List<List<Int>>, private val activity: MainActivity): RecyclerView.Adapter<RvAdapter.ColorViewHolder>() {
    class ColorViewHolder(val binding: ColorItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorViewHolder {
        return ColorViewHolder(ColorItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ColorViewHolder, position: Int) {
        holder.binding.apply {
            tvRed.text = "R - ${colors[position][0]}"
            tvGreen.text = "G - ${colors[position][1]}"
            tvBlue.text = "B - ${colors[position][2]}"
            cvColor.setBackgroundColor(Color.rgb(colors[position][0], colors[position][1], colors[position][2]))
            cvColor.setOnClickListener {
                if(activity.bg==position){
                    activity.bg = -1
                    activity.llMain.setBackgroundColor(Color.WHITE)
                }else{
                    activity.bg = position
                    activity.llMain.setBackgroundColor(Color.rgb(colors[position][0], colors[position][1], colors[position][2]))
                }
                Toast.makeText(activity, "Color Changed", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun getItemCount() = colors.size

    fun setData(colors: List<List<Int>>){
        this.colors = colors
        notifyDataSetChanged()
    }

}