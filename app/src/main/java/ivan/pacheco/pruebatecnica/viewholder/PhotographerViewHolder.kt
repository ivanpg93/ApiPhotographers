package ivan.pacheco.pruebatecnica.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ivan.pacheco.pruebatecnica.databinding.ItemPhotographerBinding
import ivan.pacheco.pruebatecnica.model.PhotographerModel

class PhotographerViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemPhotographerBinding.bind(view)

    /**
     * Asignamos los datos de cada fotografo en su item
     */
    fun bind(photographerModel: PhotographerModel) {
        Picasso.get().load(photographerModel.image).into(binding.ivPhoto)
        binding.txtName.text = photographerModel.name
        binding.txtApellido.text = photographerModel.apellido
    }

}