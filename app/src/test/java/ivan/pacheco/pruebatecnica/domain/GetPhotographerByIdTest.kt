package ivan.pacheco.pruebatecnica.domain

import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import ivan.pacheco.pruebatecnica.data.PhotographerRepository
import ivan.pacheco.pruebatecnica.model.Photographer
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

internal class GetPhotographerByIdTest {

    @RelaxedMockK
    private lateinit var photographerRepository: PhotographerRepository

    lateinit var getPhotographerById: GetPhotographerById

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        getPhotographerById = GetPhotographerById(photographerRepository)
    }

    @Test
    fun `devuelve un photographer según la id`() = runBlocking {
        // Given
        val photographer = Photographer("1", "phEmail@gmail.com", "phName", "phApellido", "asdada", null, null, null, null)
        coEvery { photographerRepository.getPhotographer(photographer.id) } returns photographer

        // When
        val response = getPhotographerById(photographer.id)

        // Then
        coVerify(exactly = 1) { photographerRepository.getPhotographer(photographer.id) }
        assert(photographer == response)
    }

}