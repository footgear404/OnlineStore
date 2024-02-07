package ge.semenchuk.store.app.stroreapp.domain.entity

interface User {
    val uName: String
    val uSecondName: String
    val uPhoneNumber: String

    fun getFullName(): String {
        return "$uSecondName $uName"
    }
}