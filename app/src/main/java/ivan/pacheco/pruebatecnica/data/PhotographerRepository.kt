package ivan.pacheco.pruebatecnica.data

import ivan.pacheco.pruebatecnica.data.database.dao.PhotographerDao
import ivan.pacheco.pruebatecnica.data.database.entities.PhotographerEntity
import ivan.pacheco.pruebatecnica.model.Photographer
import ivan.pacheco.pruebatecnica.model.toDomain
import ivan.pacheco.pruebatecnica.network.PhotographerService
import javax.inject.Inject

class PhotographerRepository @Inject constructor(private val api: PhotographerService, private val photographerDao: PhotographerDao) {

    /**
     * Devuelve una lista de fotografos del servidor API Retrofit y lo mapea de Model a Photographer
      */
    suspend fun getAllPhotographersFromApi(): List<Photographer> {
        val response = api.getPhotographers()
        return response.fotografos.map { it.toDomain() }
    }

    /**
     * Devuelve una lista de los fotografos de la DB y lo mapea de Entity a Photographer
     */
    suspend fun getAllPhotographersFromDb(): List<Photographer> {
        val response = photographerDao.getAllPhotographers()
        return response.map { it.toDomain() }
    }

    /**
     * Inserta todos los fotografos de la lista a la DB
     */
    suspend fun insertPhotographers(photographers: List<PhotographerEntity>) {
        photographerDao.insertAll(photographers)
    }

    /**
     * Borra los registros de la tabla photographer_table de la DB
     */
    suspend fun clearPhotographers() {
        photographerDao.deleteAllPhotographers()
    }

    /**
     * Devuelve el fotografo que coincide con la id y lo mapea de Entity a Photographer
     */
    suspend fun getPhotographer(id: String): Photographer {
        val response = photographerDao.getPhotographer(id)
        return response.toDomain()
    }

}