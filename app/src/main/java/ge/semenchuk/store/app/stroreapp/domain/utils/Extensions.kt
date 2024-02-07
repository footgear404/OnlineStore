package ge.semenchuk.store.app.stroreapp.domain.utils

import ge.semenchuk.store.app.stroreapp.domain.dto.ItemDto

fun String.unmaskedPhoneNumber(): String {
    val regex = Regex("""\+(\d) \((\d{3})\) (\d{3}) (\d{2}) (\d{2})""")
    return regex.replace(this) {
        "+${it.groupValues[1]} ${it.groupValues[2]} ${it.groupValues[3]}-${it.groupValues[4]}-${it.groupValues[5]}"
    }
}

fun List<ItemDto>.goodsCount(): String {
    val number: Int = this.size
    val lastDigit = number % 10
    val lastTwoDigits = number % 100

    return when {
        lastTwoDigits in 11..14 -> "$number товаров"
        lastDigit == 1 -> "$number товар"
        lastDigit in 2..4 -> "$number товара"
        else -> "$number товаров"
    }
}