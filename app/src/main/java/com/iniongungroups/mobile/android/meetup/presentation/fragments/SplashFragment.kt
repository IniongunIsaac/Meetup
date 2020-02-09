package com.iniongungroups.mobile.android.meetup.presentation.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.iniongungroups.mobile.android.meetup.R
import java.util.*
import kotlin.concurrent.schedule


class SplashFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Timer().schedule(2000) {
            findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToIntroFragment())
        }

    }


}
