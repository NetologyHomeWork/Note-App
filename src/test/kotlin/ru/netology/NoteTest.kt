package ru.netology

import org.junit.Assert
import org.junit.Test
import ru.netology.domain.note.Note
import ru.netology.presentation.ModelNote

class NoteTest {

    @Test
    fun addNoteTest() {
        val modelNote = fillModelNote()
        val emptySize = 0
        Assert.assertNotEquals(emptySize, modelNote.listNotes.size)
    }

    @Test
    fun editNoteTest() {
        val modelNote = fillModelNote()
        val note = Note(id = 17, title = "edit", text = "edit")
        modelNote.edit(note)
        Assert.assertEquals(modelNote.listNotes[0], note)
    }

    @Test
    fun deleteNoteTest() {
        val modelNote = fillModelNote()
        modelNote.delete(modelNote.listNotes[2])
        Assert.assertTrue(modelNote.listNotes[2].isDeleted)
    }

    @Test
    fun getNoteListTest() {
        val modelNote = fillModelNote()
        Assert.assertNotNull(modelNote.listNotes)
    }

    @Test
    fun getNoteById_successTest() {
        val modelNote = fillModelNote()
        val note = modelNote.getNoteById(23)
        Assert.assertEquals(modelNote.listNotes[0], note)
    }

    @Test(expected = RuntimeException::class)
    fun getNoteById_failTest() {
        val modelNote = fillModelNote()
        modelNote.getNoteById(0)
    }

    private fun fillModelNote(): ModelNote {
        val modelNote = ModelNote()
        for (i in 0 until 5) {
            val note = Note("Title ${i+1}", "Text: ${i+1}")
            modelNote.add(note)
        }
        return modelNote
    }
}