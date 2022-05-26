package ru.netology.data

import ru.netology.domain.ItemRepository
import ru.netology.domain.note.Note

class NoteRepositoryImpl : ItemRepository<Note> {

    val listNotes = mutableListOf<Note>()

    override fun addItem(item: Note) {
        listNotes.add(item)
    }

    override fun editItem(item: Note) {
        val note = getItemById(item.id)
        /*print("Enter the title for edit this note: ")
        val title = readln()
        print("Enter the text for edit this note: ")
        val text = readln()*/
        listNotes.remove(note)
        listNotes.add(item)
    }

    override fun deleteItem(item: Note) {
        val note = getItemById(item.id)
        if (note.isDeleted) throw RuntimeException("Note already deleted")
        val deletedNote = note.copy(isDeleted = true)
        listNotes.remove(note)
        listNotes.add(deletedNote)
    }

    override fun getItemList(): Iterable<Note> {
        return listNotes
    }

    override fun getItemById(itemId: Int): Note {
        return listNotes.find { it.id == itemId } ?: throw RuntimeException("Notes was not found")
    }
}