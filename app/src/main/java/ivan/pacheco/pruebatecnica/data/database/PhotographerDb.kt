package ivan.pacheco.pruebatecnica.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ivan.pacheco.pruebatecnica.data.database.dao.PhotographerDao
import ivan.pacheco.pruebatecnica.data.database.entities.PhotographerEntity

/**
 * Clase que indica las entidades que se van a guardar en la DB
 */
@Database(entities = [PhotographerEntity::class], version = 1)
abstract class PhotographerDb: RoomDatabase() {

    /**
     * Función abstracta que devuelve un PhotographerDAO
     */
    abstract fun getPhotographerDao(): PhotographerDao

}