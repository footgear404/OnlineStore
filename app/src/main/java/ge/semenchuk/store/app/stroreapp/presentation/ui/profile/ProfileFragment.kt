package ge.semenchuk.store.app.stroreapp.presentation.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import ge.semenchuk.store.app.stroreapp.databinding.FragmentProfileBinding
import ge.semenchuk.store.app.stroreapp.domain.utils.Constants.EMPTY_SRTING
import ge.semenchuk.store.app.stroreapp.domain.utils.goodsCount
import ge.semenchuk.store.app.stroreapp.presentation.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfileFragment : BaseFragment<FragmentProfileBinding>() {

    private val profileFragmentViewModel by viewModel<ProfileFragmentViewModel>()

    override fun initBinding(inflater: LayoutInflater): FragmentProfileBinding =
        FragmentProfileBinding.inflate(inflater)

    override fun initUI() {
        binding.actionBar.toolBar.title = fragmentTitle
        binding.favoriteNail.setOnClickListener { navigateTo(ProfileFragmentDirections.actionProfileFragmentToFavoriteItemsFragment()) }

        binding.logout.setOnClickListener {
            logout()
        }
    }

    private fun logout() {
        profileFragmentViewModel.logout()
        navigateTo(ProfileFragmentDirections.actionProfileFragmentToNavigationAuth())
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()
        runObservers()

    }

    private fun runObservers() {
        flowObserver(profileFragmentViewModel.favorite) { listItems ->
            if (listItems.isNotEmpty()) {
                binding.favoriteNail.setDescription(listItems.goodsCount())
            }
        }

        flowObserver(profileFragmentViewModel.user) {
            with(binding) {
                userNail.setTitle(it?.getFullName() ?: EMPTY_SRTING)
                userNail.setDescription(it?.uPhoneNumber ?: EMPTY_SRTING)
            }
        }
    }
}

