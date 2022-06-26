package com.example.colors.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.colors.databinding.ColorItemBinding

class RvAdapter(private var colors: List<List<Int>>): RecyclerView.Adapter<RvAdapter.ColorViewHolder>() {
    class ColorViewHolder(val binding: ColorItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorViewHolder {
        return ColorViewHolder(ColorItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ColorViewHolder, position: Int) {
        holder.binding.apply {
            tvColor.text = "rgb: ${colors[position][0]}, ${colors[position][1]}, ${colors[position][2]}"
            tvColor.setTextColor(Color.rgb(colors[position][0], colors[position][1], colors[position][2]))
        }
    }

    override fun getItemCount() = colors.size

    fun setData(colors: List<List<Int>>){
        this.colors = colors
        notifyDataSetChanged()
    }

}