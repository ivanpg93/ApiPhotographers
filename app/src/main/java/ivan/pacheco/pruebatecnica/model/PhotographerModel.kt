package ivan.pacheco.pruebatecnica.model

import com.google.gson.annotations.SerializedName

/**
 * DataClass Photographer que define el Model para almacenar los datos de la API
 */
data class PhotographerModel(
    val id: String,
    val email: String?,
    @SerializedName("first_name") val name: String?,
    @SerializedName("last_name") val apellido: String?,
    val description: String?,
    val image: String?,
    val facebook: String?,
    val instagram: String?,
    val webpage: String?/*,
    @SerializedName("results") val phList: List<PhotographerModel>*/
)