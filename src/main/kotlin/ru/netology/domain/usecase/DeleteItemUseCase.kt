package ru.netology.domain.usecase

import ru.netology.domain.ItemRepository

class DeleteItemUseCase<T>(private val repository: ItemRepository<T>) {

    fun deleteItem(item: T) {
        repository.deleteItem(item)
    }
}