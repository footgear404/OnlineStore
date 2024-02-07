package ge.semenchuk.store.app.stroreapp.domain.usecase.interfaces

import ge.semenchuk.store.app.stroreapp.domain.dto.ItemDto
import kotlinx.coroutines.flow.Flow

interface GetFavoritesUseCase {

    fun execute(): Flow<List<ItemDto>>

}