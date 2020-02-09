package com.iniongungroups.mobile.android.meetup.auth.fragments


import android.os.Bundle
import android.view.View
import com.iniongungroups.mobile.android.meetup.auth.AuthActivity
import com.iniongungroups.mobile.android.meetup.auth.AuthActivityViewModel
import com.iniongungroups.mobile.android.meetup.auth.BR
import com.iniongungroups.mobile.android.meetup.auth.R
import com.iniongungroups.mobile.android.meetup.auth.databinding.FragmentLoginBinding
import com.iniongungroups.mobile.android.meetup.common.base.BaseFragment
import com.iniongungroups.mobile.android.meetup.common.utils.liveDataEvent.LiveDataEventObserver
import com.iniongungroups.mobile.android.meetup.common.utils.navigation.AppActivityNavCommands
import com.iniongungroups.mobile.android.meetup.common.utils.navigation.AppFragmentNavCommands
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : BaseFragment<FragmentLoginBinding, AuthActivityViewModel>() {

    private lateinit var binding: FragmentLoginBinding

    private val authActivityViewModel by lazy { (requireActivity() as AuthActivity).authActivityViewModel }

    override fun getViewModel() = authActivityViewModel

    override fun getLayoutId() = R.layout.fragment_login

    override fun getBindingVariable() = BR.ViewModel

    override fun getLayoutBinding(binding: FragmentLoginBinding) {
        this.binding = binding
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        signUpButton.setOnClickListener {
            navigate(AppFragmentNavCommands.To(LoginFragmentDirections.actionLoginFragmentToRegisterFragment()))
        }
    }

    override fun setViewModelObservers() {
        super.setViewModelObservers()

        authActivityViewModel.authResultLiveData.observe(this, LiveDataEventObserver {

            startActivity(AppActivityNavCommands.getHomeActivityIntent(requireContext()))

            activity!!.finish()
        })
    }

}
