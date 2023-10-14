package com.project.test

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.test.databinding.ItemCityBinding

class CityAdapter : RecyclerView.Adapter<CityAdapter.ViewHolder>() {
    private var list: MutableList<City> = mutableListOf()
    var onCheckClick: ((Int) -> Unit)? = null

    inner class ViewHolder(private val binding: ItemCityBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.checkbox.setOnClickListener {
                list[adapterPosition].isSelected=binding.checkbox.isSelected
                onCheckClick?.invoke(adapterPosition)
            }
        }

        fun bindData(city: City) {
            binding.city=city

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(list[position])
    }

    fun setData(nlist: List<City>) {
        list.clear()
        list.addAll(nlist)
        notifyDataSetChanged()
    }
}