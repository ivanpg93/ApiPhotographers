package ivan.pacheco.pruebatecnica.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ivan.pacheco.pruebatecnica.domain.GetPhotographers
import ivan.pacheco.pruebatecnica.model.Photographer
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhotographerViewModel @Inject constructor(private val getPhotographers: GetPhotographers) : ViewModel() {

    val photographerModelLiveData = MutableLiveData<Photographer>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate() {
        viewModelScope.launch {
            // Inicializamos el progressBar antes de obtener los datos
            isLoading.postValue(true)
            val result = getPhotographers()

            /* Si la lista no está vacía ni es nula, quitamos el progressBar y
             asignamos los datos a los objetos de la lista del LiveData */
            if(result.isNotEmpty()) {
                result.forEach { photographerModelLiveData.postValue(it) }
                isLoading.postValue(false)
            }
        }
    }

}