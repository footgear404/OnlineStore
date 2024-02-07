package ge.semenchuk.store.app.stroreapp.domain.utils

import android.view.View
import android.widget.AdapterView
import ge.semenchuk.store.app.stroreapp.domain.utils.support.SortCriteria
import ge.semenchuk.store.app.stroreapp.domain.utils.support.SortCriteria.BY_PRICE_ASC
import ge.semenchuk.store.app.stroreapp.domain.utils.support.SortCriteria.BY_PRICE_DESC
import ge.semenchuk.store.app.stroreapp.domain.utils.support.SortCriteria.BY_RATE

class SortItemsSelectedListener(
    private val sortItems: (criteria: SortCriteria) -> Unit,
) : AdapterView.OnItemSelectedListener {

    private var isInitialized = false
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        if (isInitialized) {
            when (position) {
                0 -> sortItems(BY_RATE)
                1 -> sortItems(BY_PRICE_ASC)
                2 -> sortItems(BY_PRICE_DESC)
            }
            return
        }
        isInitialized = true
    }

    override fun onNothingSelected(parent: AdapterView<*>?) = Unit
}