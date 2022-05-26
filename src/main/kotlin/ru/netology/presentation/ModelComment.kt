package ru.netology.presentation

import ru.netology.data.CommentRepositoryImpl
import ru.netology.domain.comment.Comment
import ru.netology.domain.usecase.*

class ModelComment {
    private val repository = CommentRepositoryImpl()
    private val addItemUseCase = AddItemUseCase(repository)
    private val editItemUseCase = EditItemUseCase(repository)
    private val deleteItemUseCase = DeleteItemUseCase(repository)
    private val getItemListUseCase = GetItemListUseCase(repository)
    private val getItemByIdUseCase = GetItemByIdUseCase(repository)

    val listComments
        get() = getItemListUseCase.getItemList().toList().sortedBy { it.id }


    fun add(comment: Comment) {
        addItemUseCase.addItem(comment)
    }

    fun edit(comment: Comment) {
        editItemUseCase.editItem(comment)
    }

    fun delete(comment: Comment) {
        deleteItemUseCase.deleteItem(comment)
    }

    fun getCommentById(commentId: Int): Comment {
        return getItemByIdUseCase.getItemById(commentId)
    }

    fun restoreComment(commentId: Int) {
        repository.restoreComment(commentId)
    }
}