package com.iniongungroups.mobile.android.meetup.presentation.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.iniongungroups.mobile.android.meetup.R
import com.iniongungroups.mobile.android.meetup.common.utils.navigation.AppActivityNavCommands
import kotlinx.android.synthetic.main.fragment_intro.*

class IntroFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_intro, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        skipIntroButton.setOnClickListener {
            startActivity(AppActivityNavCommands.getAuthActivityIntent(activity!!.applicationContext))
            activity!!.finish()
        }
    }

}
