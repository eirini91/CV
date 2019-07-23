package com.eirinitelevantou.cv.ui.base

import androidx.recyclerview.widget.RecyclerView
import android.view.View

abstract class BaseViewHolder(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {

    abstract fun onBind(position: Int)
}
