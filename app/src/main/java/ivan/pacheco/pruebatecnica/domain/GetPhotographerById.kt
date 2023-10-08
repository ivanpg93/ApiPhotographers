package ivan.pacheco.pruebatecnica.domain

import ivan.pacheco.pruebatecnica.data.PhotographerRepository
import ivan.pacheco.pruebatecnica.data.database.entities.toDatabase
import ivan.pacheco.pruebatecnica.model.Photographer
import javax.inject.Inject

class GetPhotographerById @Inject constructor(private val repository: PhotographerRepository) {

    /**
     * Obtiene el fotografo según la id al llamar a la clase
     */
    suspend operator fun invoke(id: String): Photographer {
        return repository.getPhotographer(id)
    }
}