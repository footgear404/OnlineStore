package ge.semenchuk.store.app.stroreapp.presentation.ui.profile.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.navigation.fragment.findNavController
import ge.semenchuk.store.app.stroreapp.databinding.FragmentFavoriteBinding
import ge.semenchuk.store.app.stroreapp.domain.dto.ItemDto
import ge.semenchuk.store.app.stroreapp.domain.utils.support.Action
import ge.semenchuk.store.app.stroreapp.presentation.adapters.StoreItemsAdapter
import ge.semenchuk.store.app.stroreapp.presentation.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteItemsFragment : BaseFragment<FragmentFavoriteBinding>() {

    private val favoriteFragmentViewModel by viewModel<FavoriteFragmentViewModel>()
    private val storeItemsAdapter = StoreItemsAdapter(::handleClick)

    override fun initBinding(inflater: LayoutInflater): FragmentFavoriteBinding =
        FragmentFavoriteBinding.inflate(inflater)

    override fun initUI() {
        binding.actionbar.toolBar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
        binding.actionbar.toolBar.title = fragmentTitle
        binding.recyclerView.adapter = storeItemsAdapter
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()

        flowObserver(favoriteFragmentViewModel.favorite) {
            storeItemsAdapter.submitList(it)
        }
    }

    private fun handleClick(action: Action, itemDto: ItemDto, position: Int) {
        when (action) {
            Action.CLICK -> {

            }

            Action.FAVORITE -> {
                favoriteFragmentViewModel.removeFromFavorite(itemDto)
                storeItemsAdapter.notifyItemRemoved(position)
            }

            Action.BUY -> Unit
        }
    }
}