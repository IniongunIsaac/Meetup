package com.iniongungroups.mobile.android.meetup.common.viewholders

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Isaac Iniongun on 2020-02-09.
 * For Meetup project.
 */

abstract class AppBaseViewHolder <T> (
    binding: ViewDataBinding
): RecyclerView.ViewHolder(binding.root) {

    abstract fun bindItem(item: T)
}