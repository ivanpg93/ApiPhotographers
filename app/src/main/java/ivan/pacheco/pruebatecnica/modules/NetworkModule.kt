package ivan.pacheco.pruebatecnica.modules

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ivan.pacheco.pruebatecnica.network.Api
import ivan.pacheco.pruebatecnica.utils.Utils
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Módulo para proveer/inyectar dependencias de librerías o interfaces
 */
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    /**
     * Define una clase Singleton para proveer Retrofit y que mantenga una única instancia
     */
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Utils.url)
            .addConverterFactory(GsonConverterFactory.create())
            .client(Utils.getClient())
            .build()
    }

    /**
     * Proveemos Retrofit para poder inyectar la API
     */
    @Singleton
    @Provides
    fun provideApi(retrofit: Retrofit): Api {
        return retrofit.create(Api::class.java)
    }

}