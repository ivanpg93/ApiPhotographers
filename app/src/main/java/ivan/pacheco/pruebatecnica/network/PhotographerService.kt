package ivan.pacheco.pruebatecnica.network

import ivan.pacheco.pruebatecnica.model.Items
import ivan.pacheco.pruebatecnica.utils.Utils
import ivan.pacheco.pruebatecnica.utils.Utils.url
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Clase que hace una llamada a internet para obtener los fotografos de la API
 */
class PhotographerService @Inject constructor(private val api: Api) {

    suspend fun getPhotographers(): Items {
        return withContext(Dispatchers.IO) {
            val response = api.getAllPhotographers(url)
            response.body()!!
        }
    }

}