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

internal class GetPhotographersTest {

    @RelaxedMockK
    private lateinit var photographerRepository: PhotographerRepository

    lateinit var getPhotographers: GetPhotographers

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        getPhotographers = GetPhotographers(photographerRepository)
    }

    @Test
    fun `cuando la api no retorne nada, devuelve los valores de la db`() = runBlocking {
        // Given
        coEvery { photographerRepository.getAllPhotographersFromApi() } returns emptyList()

        // When
        getPhotographers()

        // Then
        coVerify(exactly = 1) { photographerRepository.getAllPhotographersFromDb() }
        coVerify(exactly = 0) { photographerRepository.clearPhotographers() }
        coVerify(exactly = 0) { photographerRepository.insertPhotographers(any()) }
    }

    @Test
    fun `cuando la api retorne algo, devuelve los valores de la api`() = runBlocking {
        //Given
        val phList = listOf(Photographer("1", "phEmail@gmail.com", "phName", "phApellido", "asdada", null, null, null, null))
        coEvery { photographerRepository.getAllPhotographersFromApi() } returns phList

        // When
        val response = getPhotographers()

        //Then
        coVerify(exactly = 1) { photographerRepository.clearPhotographers() }
        coVerify(exactly = 1) { photographerRepository.insertPhotographers(any()) }
        coVerify(exactly = 0) { photographerRepository.getAllPhotographersFromDb() }
        assert(phList == response)
    }

}