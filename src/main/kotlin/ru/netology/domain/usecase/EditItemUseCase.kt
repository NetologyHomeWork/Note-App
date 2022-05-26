package ru.netology.domain.usecase

import ru.netology.domain.ItemRepository

class EditItemUseCase<T>(private val repository: ItemRepository<T>) {
    fun editItem(item: T) {
        repository.editItem(item)
    }
}