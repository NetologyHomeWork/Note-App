package ru.netology.presentation

import ru.netology.data.NoteRepositoryImpl
import ru.netology.domain.note.Note
import ru.netology.domain.usecase.*

class ModelNote {
    private val repository = NoteRepositoryImpl()
    private val addItemUseCase = AddItemUseCase(repository)
    private val editItemUseCase = EditItemUseCase(repository)
    private val deleteItemUseCase = DeleteItemUseCase(repository)
    private val getItemListUseCase = GetItemListUseCase(repository)
    private val getItemByIdUseCase = GetItemByIdUseCase(repository)

    val listNotes
        get() = getItemListUseCase.getItemList().toList().sortedBy { it.id }


    fun add(note: Note) {
        addItemUseCase.addItem(note)
    }

    fun edit(note: Note) {
        editItemUseCase.editItem(note)
    }

    fun delete(note: Note) {
        deleteItemUseCase.deleteItem(note)
    }

    fun getNoteById(noteId: Int): Note {
        return getItemByIdUseCase.getItemById(noteId)
    }
}