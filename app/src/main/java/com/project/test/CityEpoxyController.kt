package com.project.test

import android.content.Context
import com.airbnb.epoxy.TypedEpoxyController

class CityEpoxyController(val context: Context) : TypedEpoxyController<List<City>>() {
    override fun buildModels(data: List<City>) {
        data.forEachIndexed { t, it->
            itemCity {
                id("$t${it.name}")
                city(it)
            }
        }
    }

}