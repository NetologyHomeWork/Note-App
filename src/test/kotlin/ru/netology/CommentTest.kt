package ru.netology

import org.junit.Assert
import org.junit.Test
import ru.netology.domain.comment.Comment
import ru.netology.presentation.ModelComment

class CommentTest {
    private val modelComment = ModelComment()

    init {
        for (i in 0 until 5) {
            val comment = Comment("Text: ${i+1}")
            modelComment.add(comment)
        }
    }

    @Test
    fun addCommentTest() {
        val emptySize = 0
        Assert.assertNotEquals(emptySize, modelComment.listComments.size)
    }

    @Test
    fun editCommentTest() {
        val comment = Comment(id = 27, text = "edit")
        modelComment.edit(comment)
        Assert.assertEquals(modelComment.listComments[0], comment)
    }

    @Test
    fun deleteCommentTest() {
        modelComment.delete(modelComment.listComments[2])
        Assert.assertTrue(modelComment.listComments[2].isDeleted)
    }

    @Test
    fun getCommentListTest() {
        Assert.assertNotNull(modelComment.listComments)
    }

    @Test
    fun getCommentById_successTest() {
        val comment = modelComment.getCommentById(22)
        Assert.assertEquals(modelComment.listComments[0], comment)
    }

    @Test(expected = RuntimeException::class)
    fun getCommentById_failTest() {
        modelComment.getCommentById(0)
    }

    @Test
    fun restoreCommentTest_successTest() {
        val deletedComment = Comment("Deleted",id = 39, isDeleted = true)
        modelComment.edit(deletedComment)
        modelComment.restoreComment(39)
        Assert.assertFalse(modelComment.listComments[4].isDeleted)
    }

    @Test(expected = RuntimeException::class)
    fun restoreCommentTest_failureTest() {
        val notDeletedComment = Comment("Not Deleted",id = 5)
        modelComment.edit(notDeletedComment)
        modelComment.restoreComment(5)
    }
}