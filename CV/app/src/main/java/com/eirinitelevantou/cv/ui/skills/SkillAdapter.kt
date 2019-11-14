package com.eirinitelevantou.cv.ui.skills

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eirinitelevantou.cv.databinding.RowExperienceBinding
import com.eirinitelevantou.cv.databinding.RowSkillBinding
import com.eirinitelevantou.cv.network.model.Job
import com.eirinitelevantou.cv.network.model.Skill
import com.squareup.picasso.Picasso
import java.lang.Exception

class SkillAdapter(private val context:Context, private val items: List<Skill>?) : RecyclerView.Adapter<SkillAdapter.ViewHolder>() {
    var onItemClick: ((Skill) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RowSkillBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items?.size!!

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items?.get(position)!!)

    inner class ViewHolder(val binding: RowSkillBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Skill) {
            binding.item = item
            Picasso.get()
                .load(item.icon)
                .into(binding.skillIcon, object : com.squareup.picasso.Callback {
                    override fun onError(e: Exception?) {
                    }
                    override fun onSuccess() {
                        if (binding.progressBar1 != null) {
                            binding.progressBar1.setVisibility(View.GONE)
                        }
                    }
                })

        }

        init {
            binding.parentLayout.setOnClickListener {
                onItemClick?.invoke(items?.get(adapterPosition)!!)
            }
        }
    }
}