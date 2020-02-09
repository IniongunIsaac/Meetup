package com.iniongungroups.mobile.android.meetup.home

import com.iniongungroups.mobile.android.meetup.common.base.BaseActivity
import com.iniongungroups.mobile.android.meetup.home.databinding.ActivityHomeBinding
import javax.inject.Inject

class HomeActivity : BaseActivity<ActivityHomeBinding, HomeActivityViewModel>() {

    private lateinit var binding: ActivityHomeBinding

    @Inject
    lateinit var homeActivityViewModel: HomeActivityViewModel

    override fun getLayoutId() = R.layout.activity_home

    override fun getViewModel() = homeActivityViewModel

    override fun getBindingVariable() = BR.ViewModel

    override fun getBinding(binding: ActivityHomeBinding) {
        this.binding = binding
    }

}

