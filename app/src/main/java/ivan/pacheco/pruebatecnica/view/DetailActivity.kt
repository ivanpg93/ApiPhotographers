package ivan.pacheco.pruebatecnica.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import ivan.pacheco.pruebatecnica.databinding.ActivityDetailBinding
import ivan.pacheco.pruebatecnica.domain.GetPhotographerById
import ivan.pacheco.pruebatecnica.model.Photographer
import ivan.pacheco.pruebatecnica.viewmodel.DetailViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    private val detailViewModel: DetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Recogemos los valores enviados de la activity anterior
        val bundle = intent.extras

        // Asignamos la variable id del item seleccionado anteriormente
        val id = bundle?.getString("id")

        // Buscamos al fotógrafo por su id
        detailViewModel.getPhotographer(id!!)

        // Asignamos los valores del livedata para mostrarlos por pantalla
        detailViewModel.photographerModelLiveData.observe(this, Observer {
            binding.txtName.text = it.name
            binding.txtApellido.text = it.apellido
            binding.txtDescription.text = it.description
            Picasso.get().load(it.image).into(binding.ivPhoto)
        })


        // Asignamos la función "atrás" al botón de la toolbar
        binding.toolbar.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

    }

}