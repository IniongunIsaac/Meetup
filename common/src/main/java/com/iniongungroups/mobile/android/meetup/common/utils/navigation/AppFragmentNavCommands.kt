package com.iniongungroups.mobile.android.meetup.common.utils.navigation

import androidx.annotation.IdRes
import androidx.navigation.NavDirections

/**
 * Created by Isaac Iniongun on 2020-02-08.
 * For Meetup project.
 */

sealed class AppFragmentNavCommands {
    data class To(val direction: NavDirections): AppFragmentNavCommands()
    object Back: AppFragmentNavCommands()
    data class BackTo(@IdRes val destinationId: Int): AppFragmentNavCommands()
    object BackToRoot: AppFragmentNavCommands()
}