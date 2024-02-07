package ge.semenchuk.store.app.stroreapp.domain.entity

import ge.semenchuk.store.app.stroreapp.domain.dto.FeedbackDto
import ge.semenchuk.store.app.stroreapp.domain.dto.InfoDto
import ge.semenchuk.store.app.stroreapp.domain.dto.PriceDto

interface Item {
    val available: Int
    val description: String?
    val feedbackDto: FeedbackDto?
    val id: String
    val infoDto: List<InfoDto?>
    val ingredients: String?
    val priceDto: PriceDto?
    val subtitle: String?
    val tags: List<String?>
    val title: String?
    val isFavorite: Boolean
}