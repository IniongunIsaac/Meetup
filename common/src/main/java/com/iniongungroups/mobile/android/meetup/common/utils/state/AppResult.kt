package com.iniongungroups.mobile.android.meetup.common.utils.state

/**
 * Created by Isaac Iniongun on 2020-02-08.
 * For Meetup project.
 */

class AppResult <out D> constructor(
    val state: AppState,
    val message: String? = null,
    val data: D? = null
){

    companion object {

        @JvmStatic
        fun <D> success(
            data: D? = null,
            message: String? = null
        ): AppResult<D> = AppResult(
            state = AppState.SUCCESS,
            data = data,
            message = message
        )

        @JvmStatic
        fun <D> warning(
            message: String? = null
        ): AppResult<D> = AppResult(
            state = AppState.WARNING,
            message = message
        )

        @JvmStatic
        fun <D> failed(
            message: String?
        ): AppResult<D> = AppResult(
            state = AppState.FAILED,
            data = null,
            message = message
        )

        @JvmStatic
        fun <D> loading(): AppResult<D> = AppResult(
            state = AppState.LOADING,
            data = null,
            message = null
        )

        @JvmStatic
        fun <D> loadingMore(): AppResult<D> = AppResult(
            state = AppState.LOADING_MORE,
            data = null,
            message = null
        )

    }

}