package ivan.pacheco.pruebatecnica.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ivan.pacheco.pruebatecnica.model.Photographer

/**
 * Data Class que define los Photographer en la DB
 */
@Entity(tableName = "photographer_table")
data class PhotographerEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "email") val email: String?,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "apellido") val apellido: String?,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "image") val image: String?,
    @ColumnInfo(name = "facebook") val facebook: String?,
    @ColumnInfo(name = "instagram") val instagram: String?,
    @ColumnInfo(name = "webpage") val webpage: String?
)

/**
 * Transforma un Photographer a un PhotographerEntity
 */
fun Photographer.toDatabase() = PhotographerEntity(id, email, name, apellido, description, image, facebook, instagram, webpage)