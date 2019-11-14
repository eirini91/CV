package com.eirinitelevantou.cv.ui.jobDetails

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eirinitelevantou.cv.databinding.RowExperienceBinding
import com.eirinitelevantou.cv.databinding.RowResponsibilityBinding
import com.eirinitelevantou.cv.network.model.Job
import com.eirinitelevantou.cv.network.model.Responsibility
import com.squareup.picasso.Picasso

class ResponsibilitiesAdapter(
    private val context: Context,
    private val items: List<Responsibility>?,
    private val listener: (Responsibility) -> Unit
) : RecyclerView.Adapter<ResponsibilitiesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RowResponsibilityBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items?.size!!

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(items?.get(position)!!)

    inner class ViewHolder(val binding: RowResponsibilityBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Responsibility) {
            binding.item = item
            binding.executePendingBindings()
        }

        init {
            binding.parentLayout.setOnClickListener {
                listener?.invoke(items?.get(adapterPosition)!!)

            }
        }
    }
}