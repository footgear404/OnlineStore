package ge.semenchuk.store.app.stroreapp.presentation.adapters

import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class ImageSliderAdapter(
    private val imageResIds: List<Int>,
) : RecyclerView.Adapter<ImageSliderAdapter.SliderViewHolder>() {

    // TODO: переписать под использование биндинга из xml 
    // TODO: вынести иннертные классы из адаптеров 

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderViewHolder {
        val imageView = ImageView(parent.context).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            scaleType = ImageView.ScaleType.CENTER_CROP
        }
        return SliderViewHolder(imageView)
    }

    override fun getItemCount(): Int = imageResIds.size

    override fun onBindViewHolder(holder: SliderViewHolder, position: Int) {
        holder.imageView.setImageResource(imageResIds[position])
    }

    inner class SliderViewHolder(
        val imageView: ImageView,
    ) : RecyclerView.ViewHolder(imageView)

}