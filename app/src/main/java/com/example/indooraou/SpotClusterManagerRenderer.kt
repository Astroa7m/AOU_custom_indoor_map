package com.example.indooraou

import android.content.Context
import android.view.ViewGroup
import android.widget.ImageView
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.MarkerOptions
import com.google.maps.android.clustering.Cluster
import com.google.maps.android.clustering.ClusterManager
import com.google.maps.android.clustering.view.DefaultClusterRenderer
import com.google.maps.android.ui.IconGenerator

class SpotClusterManagerRenderer(
    context: Context,
    map: GoogleMap,
    clusterManager: ClusterManager<Spot>,
) : DefaultClusterRenderer<Spot>(context, map, clusterManager) {

    private val imageView = ImageView(context).apply {
        layoutParams = ViewGroup.LayoutParams(100, 100)
        setPadding(4,4,4,4)
    }
    private val iconGenerator = IconGenerator(context).also { it.setContentView(imageView) }

    override fun onBeforeClusterItemRendered(item: Spot, markerOptions: MarkerOptions) {

        imageView.setImageResource(item.spotIconDrawable)
        val icon = iconGenerator.makeIcon()
        markerOptions.icon(BitmapDescriptorFactory.fromBitmap(icon)).title(item.title).snippet(item.snippet)
    }

    override fun shouldRenderAsCluster(cluster: Cluster<Spot>) = false

}