package ivan.pacheco.pruebatecnica.utils

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Utils {

    // URL de dónde se obtiene el JSON de la API
    val url: String = "https://inphototest.app2u.es/api/photographer/"

    /**
     * Obtiene el cliente de conexión a internet con las credenciales definidas
     */
    fun getClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(BasicAuthInterceptor("test@gmail.com", "1234"))
            .build()
    }

    /**
     * Obtiene la conexión a Retrofit
     */
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .client(getClient())
            .build()
    }
}