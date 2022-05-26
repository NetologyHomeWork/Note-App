package ru.netology.domain

interface ItemRepository<T> {

    fun addItem(item: T)

    fun editItem(item: T)

    fun deleteItem(item: T)

    fun getItemById(itemId: Int): T

    fun getItemList(): Iterable<T>
}