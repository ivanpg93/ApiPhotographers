package ivan.pacheco.pruebatecnica.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ivan.pacheco.pruebatecnica.viewholder.PhotographerViewHolder
import ivan.pacheco.pruebatecnica.R
import ivan.pacheco.pruebatecnica.model.PhotographerModel
import ivan.pacheco.pruebatecnica.view.DetailActivity

/**
 * Adapter de Photographer para mostrar el contenido en el ReciclerView
 */
class PhotographerAdapter(
    private val phList: List<PhotographerModel>,
    private val context: Context
): RecyclerView.Adapter<PhotographerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotographerViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PhotographerViewHolder(layoutInflater.inflate(R.layout.item_photographer, parent,false))
    }

    /**
     * Obtiene cada uno de los Photographer
     */
    override fun onBindViewHolder(holder: PhotographerViewHolder, position: Int) {
        val item = phList[position]
        holder.bind(item)

        /**
         * Mandamos el id del item seleccionado a la otra Activity para saber cuál mostrar en la otra pantalla
         */
        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java).apply {
                putExtra("id", item.id)
            }
            context.startActivity(intent)
        }

    }

    /**
     * Devuelve la cantidad de fotografos de la lista
     */
    override fun getItemCount(): Int = phList.size

}