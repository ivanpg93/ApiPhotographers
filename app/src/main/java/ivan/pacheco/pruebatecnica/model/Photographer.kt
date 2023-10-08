package ivan.pacheco.pruebatecnica.model

import ivan.pacheco.pruebatecnica.data.database.entities.PhotographerEntity

/**
 * Data Class base de Photographer
 */
data class Photographer(
    val id: String,
    val email: String?,
    val name: String?,
    val apellido: String?,
    val description: String?,
    val image: String?,
    val facebook: String?,
    val instagram: String?,
    val webpage: String?
)

/**
 * Pasamos de un objeto PhotographerModel a un objeto Photographer
 */
fun PhotographerModel.toDomain() = Photographer(id, email, name, apellido, description, image, facebook, instagram, webpage)

/**
 * Pasamos de un objeto PhotographerEntity a un objeto Photographer
 */
fun PhotographerEntity.toDomain() = Photographer(id, email, name, apellido, description, image, facebook, instagram, webpage)
