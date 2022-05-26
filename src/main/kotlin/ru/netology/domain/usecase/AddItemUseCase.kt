package ru.netology.domain.usecase

import ru.netology.domain.ItemRepository

class AddItemUseCase<T>(private val repository: ItemRepository<T>) {
    fun addItem(item: T) {
        repository.addItem(item)
    }
}