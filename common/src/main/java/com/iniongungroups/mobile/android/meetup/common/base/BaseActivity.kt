package com.iniongungroups.mobile.android.meetup.common.base

import android.app.Activity
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import android.view.inputmethod.InputMethodManager
import android.widget.FrameLayout
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.core.content.getSystemService
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.google.android.material.snackbar.Snackbar
import com.iniongungroups.mobile.android.meetup.common.R
import com.iniongungroups.mobile.android.meetup.common.utils.liveDataEvent.LiveDataEventObserver
import com.iniongungroups.mobile.android.meetup.common.utils.state.AppState
import dagger.android.support.DaggerAppCompatActivity

/**
 * Created by Isaac Iniongun on 2020-02-08.
 * For Meetup project.
 */

abstract class BaseActivity<in D : ViewDataBinding, out V : BaseViewModel> :
    DaggerAppCompatActivity() {

    private lateinit var dialog: AlertDialog

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun getViewModel(): V

    abstract fun getBindingVariable(): Int

    abstract fun getBinding(binding: D)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeDataBinding()

        setNotificationObserver()

        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)

        createDialog()
    }

    private fun hideKeyboardWhenUserTapsOutsideEditText() {
        val viewGroup =
            (this.findViewById<View>(android.R.id.content) as ViewGroup).getChildAt(0) as ViewGroup
        viewGroup.setOnTouchListener { _, _ ->
            hideKeyboard(this)
            true
        }
    }

    private fun initializeDataBinding() {
        val binding: D = DataBindingUtil.setContentView(this, getLayoutId())

        binding.apply {

            setVariable(getBindingVariable(), getViewModel())

            executePendingBindings()
        }

        getBinding(binding)
    }

    open fun setNotificationObserver() {
        getViewModel().notificationLiveData.observe(this, LiveDataEventObserver {

            when (it.state) {

                AppState.FAILED -> {
                    dismissLoadingDialog()
                    it.message?.let { message ->
                        showMessage(currentFocus!!, message, isError = true)
                    }
                }

                AppState.WARNING -> {
                    dismissLoadingDialog()
                    it.message?.let { message ->
                        showMessage(currentFocus!!, message, isWarning = true)
                    }

                }

                AppState.LOADING -> {
                    showLoadingDialog()
                }

                AppState.SUCCESS -> {
                    dismissLoadingDialog()
                    it.message?.let { message ->
                        showMessage(currentFocus!!, message)
                    }

                }

            }

        })
    }

    private fun createDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setView(R.layout.layout_progress_dialog)
        builder.setCancelable(false)

        dialog = builder.create()
        dialog.window?.requestFeature(Window.FEATURE_NO_TITLE)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

    fun hideKeyboard(activity: Activity) {
        val imm = getSystemService<InputMethodManager>()
        //Find the currently focused view, so we can grab the correct window token from it.
        var view = activity.currentFocus
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = View(activity)
        }
        imm!!.hideSoftInputFromWindow(view.windowToken, 0)
    }

    fun showMessage(
        rootView: View,
        text: String,
        isError: Boolean = false,
        duration: Int = Snackbar.LENGTH_SHORT,
        isWarning: Boolean = false
    ) {
        val snackBar = Snackbar.make(rootView, text, duration)
        val param = snackBar.view.layoutParams as FrameLayout.LayoutParams
        val snackBarLayout = snackBar.view as Snackbar.SnackbarLayout

        if (isWarning) snackBarLayout.setBackgroundColor(
            ContextCompat.getColor(
                this,
                R.color.warning
            )
        )
        if (isError) snackBarLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.red))
        else snackBarLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.green))

        snackBarLayout.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)
            .setTextColor(ContextCompat.getColor(this, R.color.white))
        param.gravity = Gravity.TOP
        snackBar.view.layoutParams = param
        snackBar.show()
    }

    open fun showLoadingDialog() {
        hideKeyboard(this)
        dialog.show()
    }

    open fun dismissLoadingDialog() {
        if (dialog.isShowing) dialog.dismiss()
    }

    open fun hideStatusAndNavigationBar() {
        window.decorView.apply {
            // Hide both the navigation bar and the status bar.
            // SYSTEM_UI_FLAG_FULLSCREEN is only available on Android 4.1 and higher, but as
            // a general rule, you should design your app to hide the status bar whenever you
            // hide the navigation bar.
            systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN
        }

        // Remember that you should never show the action bar if the
        // status bar is hidden, so hide that too if necessary.
        actionBar?.hide()
    }
}