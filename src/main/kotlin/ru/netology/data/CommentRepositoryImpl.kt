package ru.netology.data

import ru.netology.domain.ItemRepository
import ru.netology.domain.comment.Comment
import ru.netology.domain.usecase.RestoreCommentUseCase

class CommentRepositoryImpl : ItemRepository<Comment> {

    private val listComment = mutableListOf<Comment>()
    private val restoreComment = RestoreCommentUseCase()

    override fun addItem(item: Comment) {
        listComment.add(item)
    }

    override fun editItem(item: Comment) {
        val comment = getItemById(item.id)
        /*print("Enter the text for edit this comment")
        val text = readln()*/
        // val newComment = comment.copy(text = text)
        listComment.remove(comment)
        listComment.add(item)
    }

    override fun deleteItem(item: Comment) {
        val comment = getItemById(item.id)
        if (comment.isDeleted) throw RuntimeException("Comment already deleted")
        val deletedComment = comment.copy(isDeleted = true)
        listComment.remove(comment)
        listComment.add(deletedComment)
    }

    override fun getItemList(): Iterable<Comment> {
        return listComment
    }

    override fun getItemById(itemId: Int): Comment {
        return listComment.find { it.id == itemId } ?: throw RuntimeException("Comment was not found")
    }

    fun restoreComment(commentId: Int) {
        restoreComment.restoreComment(listComment, getItemById(commentId))
    }
}