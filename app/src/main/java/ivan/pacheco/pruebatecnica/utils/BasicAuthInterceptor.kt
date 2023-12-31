package ivan.pacheco.pruebatecnica.utils

import okhttp3.Credentials
import okhttp3.Interceptor

/**
 * Clase que define las credenciales para acceder al JSON de la API
 */
class BasicAuthInterceptor(username: String, password: String) : Interceptor {
    private var credentials: String = Credentials.basic(username, password)

    override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
        var request = chain.request()
        request = request.newBuilder().header("Authorization", credentials).build()
        return chain.proceed(request)
    }
}