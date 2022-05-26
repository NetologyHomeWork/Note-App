package ru.netology.domain.usecase

import ru.netology.domain.ItemRepository

class GetItemListUseCase<T>(private val repository: ItemRepository<T>) {
    fun getItemList(): Iterable<T> {
        return repository.getItemList()
    }
}