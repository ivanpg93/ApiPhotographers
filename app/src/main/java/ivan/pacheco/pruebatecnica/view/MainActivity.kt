package ivan.pacheco.pruebatecnica.view

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import ivan.pacheco.pruebatecnica.network.Api
import ivan.pacheco.pruebatecnica.adapter.PhotographerAdapter
import ivan.pacheco.pruebatecnica.viewmodel.PhotographerViewModel
import ivan.pacheco.pruebatecnica.databinding.ActivityMainBinding
import ivan.pacheco.pruebatecnica.model.Items
import ivan.pacheco.pruebatecnica.model.PhotographerModel
import ivan.pacheco.pruebatecnica.utils.Utils.getRetrofit
import ivan.pacheco.pruebatecnica.utils.Utils.url
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: PhotographerAdapter

    private val fotografos = mutableListOf<PhotographerModel>()

    private val photographerViewModel: PhotographerViewModel by viewModels()

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        photographerViewModel.onCreate()

        photographerViewModel.isLoading.observe(this, Observer {
            binding.progress.isVisible = it
        })

        initRecyclerView(this)
        getData()

    }

    /**
     * Inicializamos el RecyclerView en la vista
     */
    private fun initRecyclerView(context: Context) {
        adapter = PhotographerAdapter(fotografos, context)
        binding.rvPhotographers.layoutManager = LinearLayoutManager(this)
        binding.rvPhotographers.adapter = adapter
    }

    /**
     * Obtenemos todos los datos de la api
     */
    @SuppressLint("NotifyDataSetChanged")
    private fun getData() {
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(Api::class.java).getAllPhotographers(url)
            val items: Items? = call.body()
            runOnUiThread {
                if (call.isSuccessful) {
                    val photographerList: List<PhotographerModel> = items?.fotografos ?: emptyList()
                    photographerList.sortedBy { it.email }

                    fotografos.clear()
                    fotografos.addAll(photographerList)
                    adapter.notifyDataSetChanged()
                } else {
                    showError()
                }
            }
        }
    }

    /**
     * Avisa al usuario de que ha habido un error
     */
    private fun showError() {
        Toast.makeText(this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show()
    }

}