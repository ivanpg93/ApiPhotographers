package ivan.pacheco.pruebatecnica.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ivan.pacheco.pruebatecnica.data.database.entities.PhotographerEntity
import ivan.pacheco.pruebatecnica.model.Photographer

/**
 * Interfaz que contiene las funciones necesarias para la interacción con la DB
 */
@Dao
interface PhotographerDao {

    /**
     * Obtiene todos los fotografos de la tabla ordenados por la ID
     */
    @Query("SELECT * FROM photographer_table ORDER BY id ASC")
    suspend fun getAllPhotographers(): List<PhotographerEntity>

    /**
     * Inserta la lista de fotografos en la BD. Si ya existen los registros, los reemplaza
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(photographer: List<PhotographerEntity>)

    /**
     * Borra todos los registros de la tabla de fotografos
     */
    @Query("DELETE FROM photographer_table")
    suspend fun deleteAllPhotographers()

    /**
     * Obtiene un fotografo según la id
     */
    @Query("SELECT * FROM photographer_table WHERE id = :id")
    suspend fun getPhotographer(id: String): PhotographerEntity

}