package ru.netology.domain.usecase

import ru.netology.domain.comment.Comment

class RestoreCommentUseCase {
    fun restoreComment(listComment: MutableList<Comment>, comment: Comment) {
        if (!comment.isDeleted) throw RuntimeException("Comment already restored")
        val deletedComment = comment.copy(isDeleted = false)
        listComment.remove(comment)
        listComment.add(deletedComment)
    }
}