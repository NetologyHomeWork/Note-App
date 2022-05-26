package ru.netology.domain.comment

data class Comment(
    val text: String,
    val id: Int = autoIncrement,
    val fromId: Int = 123,
    val date: Int = 125_698_741,
    val isDeleted: Boolean = false
) {
    companion object {
        var autoIncrement = 1
    }

    init {
        ++autoIncrement
    }
}