package com.iniongungroups.mobile.android.meetup.home.utils

import androidx.annotation.DrawableRes

/**
 * Created by Isaac Iniongun on 2020-02-09.
 * For Meetup project.
 */

data class MeetupItem(@DrawableRes val image: Int, val description: String, val amount: String, val percentageOff: String)