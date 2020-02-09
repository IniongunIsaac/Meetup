package com.iniongungroups.mobile.android.meetup.common.bindingAdapters

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter

/**
 * Created by Isaac Iniongun on 2020-02-09.
 * For Meetup project.
 */

object DataBindingAdapters {

    @BindingAdapter("app:srcCompat")
    @JvmStatic
    fun setImageDrawable(view: AppCompatImageView, imageDrawable: Int) {
        view.setImageResource(imageDrawable)
    }

}