package com.iniongungroups.mobile.android.meetup.common.utils.navigation

import android.content.Context
import android.content.Intent

/**
 * Created by Isaac Iniongun on 2020-02-08.
 * For Meetup project.
 */

object AppActivityNavCommands {

    private fun navigationIntent(context: Context, navAction: String) = Intent(navAction).setPackage(context.packageName)

}