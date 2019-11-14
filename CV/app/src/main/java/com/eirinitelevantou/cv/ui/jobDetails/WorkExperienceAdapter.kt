package com.eirinitelevantou.cv.ui.jobDetails

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eirinitelevantou.cv.databinding.RowExamplesBinding
import com.eirinitelevantou.cv.network.model.WorkExample

class WorkExperienceAdapter(
    private val context: Context,
    private val items: List<WorkExample>?,
    private val listener: (WorkExample) -> Unit
) : RecyclerView.Adapter<WorkExperienceAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RowExamplesBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items?.size!!

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(items?.get(position)!!)

    inner class ViewHolder(val binding: RowExamplesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: WorkExample) {
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