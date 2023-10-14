package com.project.test

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.test.databinding.ItemCitySelectionBinding

class SelectedCityAdapter() : RecyclerView.Adapter<SelectedCityAdapter.ViewHolder>() {
    private var list: MutableList<City> = mutableListOf()

    class ViewHolder(private val binding: ItemCitySelectionBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindData(city: City) {
         binding.chip.text=city.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCitySelectionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }


    override fun getItemCount(): Int = list.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(list[position])
    }

    fun setData(selectedList: MutableList<City>) {
        list.clear()
        list.addAll(selectedList)
        notifyDataSetChanged()
    }
}