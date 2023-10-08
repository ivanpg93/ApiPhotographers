package ivan.pacheco.pruebatecnica.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.squareup.picasso.Picasso
import dagger.hilt.android.lifecycle.HiltViewModel
import ivan.pacheco.pruebatecnica.domain.GetPhotographerById
import ivan.pacheco.pruebatecnica.domain.GetPhotographers
import ivan.pacheco.pruebatecnica.model.Photographer
import ivan.pacheco.pruebatecnica.model.PhotographerModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val getPhotographerById: GetPhotographerById) :
    ViewModel() {

    val photographerModelLiveData = MutableLiveData<Photographer>()

    /**
     * Obtenemos el fotografo por la id y asignamos a nuestro LiveData
     */
    fun getPhotographer(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val photographer = getPhotographerById(id)
            photographerModelLiveData.postValue(photographer)
        }
    }

}