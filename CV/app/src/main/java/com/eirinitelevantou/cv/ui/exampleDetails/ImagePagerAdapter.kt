package com.eirinitelevantou.cv.ui.exampleDetails

import android.content.Context
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.eirinitelevantou.cv.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.cell_image.view.*
import java.lang.Exception

class ImagePagerAdapter(val context: Context, val items: List<String>?) : RecyclerView.Adapter<ViewHolder>() {

    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        return items?.size!!
    }

    // Inflates the item views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.cell_image, parent, false))
    }

    // Binds each animal in the ArrayList to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Picasso.get()
            .load(items!!.get(position))
            .into(holder?.image)

        Picasso.get()
            .load(items!!.get(position))
            .into(holder?.image, object : com.squareup.picasso.Callback {
                override fun onError(e: Exception?) {
                }
                override fun onSuccess() {
                    if (holder?.progressBar1 != null) {
                        holder?.progressBar1.setVisibility(View.GONE)
                    }
                }
            })
    }
}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    // Holds the TextView that will add each animal to
    val image = view.image
    val progressBar1 = view.progressBar1

}
