package ru.netology.domain.note

import ru.netology.domain.note.Note.Companion.PrivacyViewAndCommentNote.ALL_USERS
import java.util.*

/**
 * [privacy] and [commentPrivacy]
 * @see 0 -> all users
 * 1 -> only friends
 * 2-> friends and friends of friends
 * 3 -> owner
 */
data class Note(
    val title: String,
    val text: String,
    val privacyView: PrivacyViewAndCommentNote = ALL_USERS,
    val privacyComment: PrivacyViewAndCommentNote = ALL_USERS,
    var id: Int = autoIncrement,
    val ownerId: Int = 123,
    val date: Long = Date().time,
    val comments: Int = 0,
    val readComments: Int = 0,
    val viewUrl: String = "https://vk.com/$id",
    val privacy: Int = ALL,
    val commentPrivacy: Int = ALL,
    val isDeleted: Boolean = false
) {
    companion object {
        enum class PrivacyViewAndCommentNote {
            ALL_USERS, FRIENDS_USERS, FRIENDS_OF_FRIENDS_USERS, NOBODY_USERS
        }

        var autoIncrement = 1
        const val ALL = 0
        const val FRIENDS = 1
        const val FRIENDS_OF_FRIENDS = 2
        const val OWNER = 3
    }

    init {
        ++autoIncrement
    }
}

