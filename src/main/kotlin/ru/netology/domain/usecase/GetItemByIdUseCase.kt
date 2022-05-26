package ru.netology.domain.usecase

import ru.netology.domain.ItemRepository

class GetItemByIdUseCase<T>(private val repository: ItemRepository<T>) {
    fun getItemById(itemId: Int): T {
        return repository.getItemById(itemId)
    }
}