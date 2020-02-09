package com.iniongungroups.mobile.android.meetup.auth

import com.iniongungroups.mobile.android.meetup.auth.databinding.ActivityAuthBinding
import com.iniongungroups.mobile.android.meetup.common.base.BaseActivity
import javax.inject.Inject

class AuthActivity : BaseActivity<ActivityAuthBinding, AuthActivityViewModel>() {

    private lateinit var binding: ActivityAuthBinding

    @Inject
    lateinit var authActivityViewModel: AuthActivityViewModel

    override fun getLayoutId() = R.layout.activity_auth

    override fun getViewModel() = authActivityViewModel

    override fun getBindingVariable() = BR.ViewModel

    override fun getBinding(binding: ActivityAuthBinding) {
        this.binding = binding
    }

}
