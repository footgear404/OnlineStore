package ge.semenchuk.store.app.stroreapp.domain.entity

interface Price {
    val discount: Int?
    val price: String?
    val priceWithDiscount: String?
    val unit: String?
}