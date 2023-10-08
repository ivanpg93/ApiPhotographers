package ivan.pacheco.pruebatecnica.modules

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ivan.pacheco.pruebatecnica.data.database.PhotographerDb
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    // Nombre de la DB
    private const val DATABASE_NAME = "photographer_db"

    /**
     * Inyectamos la DB
     */
    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) = Room.databaseBuilder(context, PhotographerDb::class.java, DATABASE_NAME).build()

    /**
     * Inyectamos el DAO
     */
    @Singleton
    @Provides
    fun providePhotographerDao(db: PhotographerDb) = db.getPhotographerDao()

}