package ge.semenchuk.store.app.stroreapp.presentation.ui.catalog

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.core.view.isVisible
import ge.semenchuk.store.app.stroreapp.R
import ge.semenchuk.store.app.stroreapp.databinding.FragmentCatalogBinding
import ge.semenchuk.store.app.stroreapp.domain.dto.ItemDto
import ge.semenchuk.store.app.stroreapp.domain.utils.Constants
import ge.semenchuk.store.app.stroreapp.domain.utils.SortItemsSelectedListener
import ge.semenchuk.store.app.stroreapp.domain.utils.support.Action
import ge.semenchuk.store.app.stroreapp.domain.utils.support.Action.BUY
import ge.semenchuk.store.app.stroreapp.domain.utils.support.Action.CLICK
import ge.semenchuk.store.app.stroreapp.domain.utils.support.Action.FAVORITE
import ge.semenchuk.store.app.stroreapp.domain.utils.support.SortCriteria
import ge.semenchuk.store.app.stroreapp.domain.utils.support.State
import ge.semenchuk.store.app.stroreapp.presentation.adapters.StoreItemsAdapter
import ge.semenchuk.store.app.stroreapp.presentation.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class CatalogFragment : BaseFragment<FragmentCatalogBinding>() {

    private val catalogFragmentViewModel by viewModel<CatalogFragmentViewModel>()
    private val storeItemsAdapter = StoreItemsAdapter(::handleClick)
    private val sortItemsSelectedListener = SortItemsSelectedListener(::handleSortCriteria)
    override fun initBinding(inflater: LayoutInflater): FragmentCatalogBinding =
        FragmentCatalogBinding.inflate(inflater)

    override fun initUI() {
        binding.toolbarTitle.text = fragmentTitle
        binding.recyclerView.adapter = storeItemsAdapter
        binding.filterView.spinner.onItemSelectedListener = sortItemsSelectedListener

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()
        runObservers()

    }

    private fun runObservers() {
        flowObserver(catalogFragmentViewModel.items) { listItems ->
            storeItemsAdapter.submitList(listItems)
        }

        flowObserver(catalogFragmentViewModel.favorite) {
            Log.d(Constants.Log.DB, it.toString())
        }

        flowObserver(catalogFragmentViewModel.state) { state ->
            handleProgressBarVisibility(state)
            when (state) {
                State.Loading -> {
                    Log.d(Constants.Log.STATE, "$state")
                }

                State.Success -> {
                    Log.d(Constants.Log.STATE, "$state")
                }

                is State.Error -> {
                    Log.d(Constants.Log.STATE, "$state")
                    snackIt(state.message, binding.root)
                }

                State.Await -> {
                    Log.d(Constants.Log.STATE, "$state")
                }
            }
        }
    }

    private fun handleProgressBarVisibility(state: State) {
        binding.progressBar.isVisible = state == State.Loading
    }

    private fun handleClick(action: Action, itemDto: ItemDto, position: Int) {
        when (action) {
            CLICK -> { navigateTo(R.id.detailsItemFragment) }
            FAVORITE -> {
                catalogFragmentViewModel.addToFavorite(itemDto)
                storeItemsAdapter.notifyItemChanged(position, itemDto)
            }
            BUY -> Unit
        }
    }

    private fun handleSortCriteria(criteria: SortCriteria) {
        catalogFragmentViewModel.sort(by = criteria)
    }
}

