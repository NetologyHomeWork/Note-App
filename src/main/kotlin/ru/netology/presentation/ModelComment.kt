package ru.netology.presentation

import ru.netology.data.CommentRepositoryImpl
import ru.netology.domain.comment.Comment
import ru.netology.domain.usecase.AddItemUseCase
import ru.netology.domain.usecase.DeleteItemUseCase
import ru.netology.domain.usecase.EditItemUseCase
import ru.netology.domain.usecase.GetItemListUseCase

class ModelComment {
    private val repository = CommentRepositoryImpl()
    private val addItemUseCase = AddItemUseCase(repository)
    private val editItemUseCase = EditItemUseCase(repository)
    private val deleteItemUseCase = DeleteItemUseCase(repository)
    private val getItemListUseCase = GetItemListUseCase(repository)

    val listNotes
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
}