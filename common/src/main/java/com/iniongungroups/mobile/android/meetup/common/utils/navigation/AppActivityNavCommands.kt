package com.iniongungroups.mobile.android.meetup.common.utils.navigation

import android.content.Context
import android.content.Intent
import com.iniongungroups.mobile.android.meetup.common.R

/**
 * Created by Isaac Iniongun on 2020-02-08.
 * For Meetup project.
 */

object AppActivityNavCommands {

    fun getAuthActivityIntent(context: Context) = navigationIntent(context, context.getString(R.string.auth_activity_intent))
    fun getHomeActivityIntent(context: Context) = navigationIntent(context, context.getString(R.string.home_activity_intent))

    private fun navigationIntent(context: Context, navAction: String) = Intent(navAction).setPackage(context.packageName)

}