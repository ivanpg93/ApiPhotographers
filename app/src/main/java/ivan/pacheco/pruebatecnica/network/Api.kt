package ivan.pacheco.pruebatecnica.network

import ivan.pacheco.pruebatecnica.model.Items
import ivan.pacheco.pruebatecnica.model.PhotographerModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Url

/**
 * Interfaz API para obtener los datos JSON de la URL
 */
interface Api {
    @Headers("Accept: application/json")
    @GET
    suspend fun getAllPhotographers(@Url url: String): Response<Items>
}