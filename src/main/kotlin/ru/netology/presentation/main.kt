package ru.netology.presentation

import ru.netology.domain.comment.Comment
import ru.netology.domain.note.Note


fun main() {
    val modelNote = ModelNote()
    val modelComment = ModelComment()
    for (i in 0 until 5) {
        val note = Note("Title: ${i+1}", "Text: ${i+1}")
        val comment = Comment("Text: ${i+1}")
        modelNote.add(note)
        modelComment.add(comment)
    }
    modelNote.listNotes.forEach { println(it) }
    modelComment.listComments.forEach { println(it) }
    modelNote.edit(Note("Title: 30", "Text: 30", id = 2))
    modelComment.edit(Comment("Text: 20", id = 2))
    modelNote.delete(modelNote.listNotes[3])
    modelComment.delete(modelComment.listComments[3])
    println()
    modelNote.listNotes.forEach { println(it) }
    modelComment.listComments.forEach { println(it) }
}