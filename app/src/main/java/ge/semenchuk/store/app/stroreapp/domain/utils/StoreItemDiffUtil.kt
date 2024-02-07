package ge.semenchuk.store.app.stroreapp.domain.utils

import androidx.recyclerview.widget.DiffUtil
import ge.semenchuk.store.app.stroreapp.domain.dto.ItemDto

class StoreItemDiffUtil : DiffUtil.ItemCallback<ItemDto>() {

    override fun areItemsTheSame(oldItem: ItemDto, newItem: ItemDto): Boolean =
        oldItem.id == newItem.id


    override fun areContentsTheSame(oldItem: ItemDto, newItem: ItemDto): Boolean =
        oldItem == newItem

}