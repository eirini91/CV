package com.eirinitelevantou.cv.ui.experience

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eirinitelevantou.cv.databinding.RowExperienceBinding
import com.eirinitelevantou.cv.network.model.Job
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import android.view.View.GONE
import java.lang.Exception


class ExperienceAdapter(
    private val context: Context,
    private val items: List<Job>?,
    private val listener: (Job) -> Unit
) : RecyclerView.Adapter<ExperienceAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RowExperienceBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items?.size!!

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(items?.get(position)!!)

    inner class ViewHolder(val binding: RowExperienceBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Job) {
            binding.item = item
            Picasso.get()
                .load(item.icon)
                .into(binding.companyImage, object : com.squareup.picasso.Callback {
                    override fun onError(e: Exception?) {
                    }
                    override fun onSuccess() {
                        if (binding.progressBar1 != null) {
                            binding.progressBar1.setVisibility(View.GONE)
                        }
                    }
                })


            binding.executePendingBindings()
        }

        init {
            binding.parentLayout.setOnClickListener {
                listener?.invoke(items?.get(adapterPosition)!!)

            }
        }
    }
}