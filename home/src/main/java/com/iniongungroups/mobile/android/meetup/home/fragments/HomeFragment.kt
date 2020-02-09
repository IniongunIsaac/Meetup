package com.iniongungroups.mobile.android.meetup.home.fragments


import android.os.Bundle
import android.view.View
import com.iniongungroups.mobile.android.meetup.common.adapters.SingleLayoutRecyclerAdapter
import com.iniongungroups.mobile.android.meetup.common.base.BaseFragment
import com.iniongungroups.mobile.android.meetup.common.listeners.BindableItemClickListener
import com.iniongungroups.mobile.android.meetup.home.BR
import com.iniongungroups.mobile.android.meetup.home.HomeActivity
import com.iniongungroups.mobile.android.meetup.home.HomeActivityViewModel
import com.iniongungroups.mobile.android.meetup.home.R
import com.iniongungroups.mobile.android.meetup.home.databinding.FragmentHomeBinding
import com.iniongungroups.mobile.android.meetup.home.databinding.SingleMeetupItemBinding
import com.iniongungroups.mobile.android.meetup.home.utils.MeetupItem

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeActivityViewModel>(), BindableItemClickListener<MeetupItem> {

    private lateinit var binding: FragmentHomeBinding

    private val homeActivityViewModel by lazy { (requireActivity() as HomeActivity).homeActivityViewModel }

    private val meetupItemsAdapter by lazy {
        object : SingleLayoutRecyclerAdapter<SingleMeetupItemBinding, MeetupItem>(
            context = context!!,
            itemClickListener = this@HomeFragment,
            layoutId = R.layout.single_meetup_item
        ) {
            override fun getItemBindingVariable(): Int = BR.item

            override fun getItemClickListenerBindingVariable() = 0
        }
    }

    override fun getViewModel() = homeActivityViewModel

    override fun getLayoutId() = R.layout.fragment_home

    override fun getBindingVariable() = BR.ViewModel

    override fun getLayoutBinding(binding: FragmentHomeBinding) {
        this.binding = binding
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.meetupItemsRecyclerView.apply {
            adapter = meetupItemsAdapter
        }

        meetupItemsAdapter.addNewItems(
            listOf(
                MeetupItem(R.drawable.image1, "Fit and Flare", "$120.99", "10% Off"),
                MeetupItem(R.drawable.image2, "Empire Dress", "$136.00", ""),
                MeetupItem(R.drawable.image3, "Summer Vibes", "$199.99", ""),
                MeetupItem(R.drawable.image4, "Floral Fun", "$150.99", "20% Off"),
                MeetupItem(R.drawable.image5, "Fit and Flare", "$120.99", "10% Off"),
                MeetupItem(R.drawable.image6, "Empire Dress", "$136.00", "")
            )
        )

    }

    override fun onItemClicked(item: MeetupItem) { }
}
