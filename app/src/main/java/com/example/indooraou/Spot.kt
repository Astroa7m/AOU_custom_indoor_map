package com.example.indooraou

import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.clustering.ClusterItem

data class Spot(
    val name: String,
    val description: String,
    val latLng: LatLng,
    val spotIconDrawable: Int,
) : ClusterItem{
    override fun getPosition(): LatLng {
        return latLng
    }

    override fun getTitle(): String {
        return name
    }

    override fun getSnippet(): String {
        return description
    }
}