package ivan.pacheco.pruebatecnica.model

import com.google.gson.annotations.SerializedName

/**
 * Clase que obtiene una lista con los fotografos de la API del JSON
 */
data class Items(@SerializedName("results") val fotografos: List<PhotographerModel>)