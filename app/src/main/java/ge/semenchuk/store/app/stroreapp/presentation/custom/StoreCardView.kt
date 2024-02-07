package ge.semenchuk.store.app.stroreapp.presentation.custom

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.cardview.widget.CardView
import androidx.core.view.isVisible
import ge.semenchuk.store.app.stroreapp.R
import ge.semenchuk.store.app.stroreapp.databinding.StoreCardViewBinding

class StoreCardView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : CardView(context, attrs, defStyleAttr) {

    private val binding = StoreCardViewBinding.inflate(LayoutInflater.from(context))

    init {
        LayoutInflater.from(context).inflate(R.layout.store_card_view, this, true)

        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.StoreCardView, 0, 0)
            val title = typedArray.getString(R.styleable.StoreCardView_title)
            val description = typedArray.getString(R.styleable.StoreCardView_description)
            val iconStart = typedArray.getDrawable(R.styleable.StoreCardView_iconStart)
            val iconEnd = typedArray.getDrawable(R.styleable.StoreCardView_iconEnd)

            binding.title.text = title
            binding.description.text = description
            binding.description.isVisible = checkDescription(description)
            binding.iconStart.setImageDrawable(iconStart)
            binding.iconEnd.setImageDrawable(iconEnd)

            typedArray.recycle()
        }
        addView(binding.root)
    }

    private fun checkDescription(description: String?): Boolean {
        return !description.isNullOrBlank()
    }

    fun setTitle(text: String) {
        binding.title.text = text
    }

    fun setDescription(text: String) {
        binding.description.text = text
        binding.description.visibility = if (text.isBlank()) View.GONE else View.VISIBLE
    }

    fun setIconStart(drawable: Drawable) {
        binding.iconStart.setImageDrawable(drawable)
    }

    fun setIconEnd(drawable: Drawable) {
        binding.iconEnd.setImageDrawable(drawable)
    }
}