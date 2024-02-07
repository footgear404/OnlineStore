package ge.semenchuk.store.app.stroreapp

fun main() {
    println(formatPhoneNumber("+7 (111) 111 11 11"))

}

fun formatPhoneNumber(input: String): String {
    val regex = Regex("""\+(\d) \((\d{3})\) (\d{3}) (\d{2}) (\d{2})""")
    return regex.replace(input) {
        "+${it.groupValues[1]} ${it.groupValues[2]} ${it.groupValues[3]}-${it.groupValues[4]}-${it.groupValues[5]}"
    }
}