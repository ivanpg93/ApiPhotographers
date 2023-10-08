package ivan.pacheco.pruebatecnica.domain

import ivan.pacheco.pruebatecnica.data.PhotographerRepository
import ivan.pacheco.pruebatecnica.data.database.entities.toDatabase
import ivan.pacheco.pruebatecnica.model.Photographer
import javax.inject.Inject

class GetPhotographers @Inject constructor(private val repository: PhotographerRepository) {

    /**
     * Obtiene de la API una lista de todos los fotografos al llamar a la clase
     */
    suspend operator fun invoke(): List<Photographer> {
        val photographers = repository.getAllPhotographersFromApi()

        // Si la lista no está vacía, la devuelve de la API, sino la devuelve de la DB
        return if(photographers.isNotEmpty()) {
            repository.clearPhotographers()
            repository.insertPhotographers(photographers.map { it.toDatabase() })
            photographers
        } else {
            repository.getAllPhotographersFromDb()
        }
    }

}