package ge.semenchuk.store.app.stroreapp.presentation.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayoutMediator
import ge.semenchuk.store.app.stroreapp.R
import ge.semenchuk.store.app.stroreapp.databinding.ProductItemBinding
import ge.semenchuk.store.app.stroreapp.domain.dto.ItemDto
import ge.semenchuk.store.app.stroreapp.domain.utils.StoreItemDiffUtil
import ge.semenchuk.store.app.stroreapp.domain.utils.mappers.itemImageMap
import ge.semenchuk.store.app.stroreapp.domain.utils.support.Action

class StoreItemsAdapter(
    val handleClick: (action: Action, itemDto: ItemDto, position: Int) -> Unit,
) : ListAdapter<ItemDto, StoreItemsAdapter.StoreItemViewHolder>(StoreItemDiffUtil()) {

    private var item: ItemDto? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreItemViewHolder {
        return StoreItemViewHolder(
            ProductItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(
        holder: StoreItemViewHolder,
        position: Int,
        payloads: MutableList<Any>,
    ) {
        if (payloads.isNotEmpty()) {
            val item = payloads[0] as ItemDto
            holder.bind(item)
        } else {
            super.onBindViewHolder(holder, position, payloads)
        }
    }

    override fun onBindViewHolder(holder: StoreItemViewHolder, position: Int) {
        item = getItem(position)
        item?.let { holder.bind(it) }
    }

    inner class StoreItemViewHolder(
        private val binding: ProductItemBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(itemDto: ItemDto) {
            itemImageMap[itemDto.id]?.let { imageResIds ->
                val sliderAdapter = ImageSliderAdapter(imageResIds)
                binding.imageSlider.adapter = sliderAdapter
            } ?: Log.d("ViewPager2", "${itemDto.id} not found")

            TabLayoutMediator(binding.pagination, binding.imageSlider) { _, _ -> }.attach()

            setFavoriteIcon(itemDto.isFavorite)

            binding.apply {
                title.text = itemDto.title
                description.text = itemDto.description
                price.text = "${itemDto.priceDto?.priceWithDiscount ?: 0} ${itemDto.priceDto?.unit}"
                oldPrice.text = "${itemDto.priceDto?.price ?: 0} ${itemDto.priceDto?.unit}"
                rateView.rating.text = itemDto.feedbackDto?.rating.toString()
                rateView.count.text = "(${itemDto.feedbackDto?.count.toString()})"

                root.setOnClickListener { handleClick(Action.CLICK, itemDto, adapterPosition) }
                favoriteBtn.setOnClickListener {
                    handleClick(
                        Action.FAVORITE,
                        itemDto,
                        adapterPosition
                    )
                }
                buyBtn.setOnClickListener { handleClick(Action.BUY, itemDto, adapterPosition) }
            }
        }

        private fun setFavoriteIcon(isFavorite: Boolean) {
            val iconRes =
                if (isFavorite) R.drawable.favorite_filled_icon else R.drawable.favorite_unfiled_icon
            val drawable = ResourcesCompat.getDrawable(
                binding.root.context.resources,
                iconRes,
                binding.root.context.theme
            )
            binding.favoriteBtn.setImageDrawable(drawable)
        }
    }
}