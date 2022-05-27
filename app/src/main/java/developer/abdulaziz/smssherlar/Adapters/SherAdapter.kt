package developer.abdulaziz.smssherlar.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import developer.abdulaziz.smssherlar.Models.Poem
import developer.abdulaziz.smssherlar.R
import kotlinx.android.synthetic.main.item_rv.view.*

class SherAdapter(private var list: ArrayList<Poem>, private var onRVClicked: OnRVClicked) :
    RecyclerView.Adapter<SherAdapter.Vh>() {

    inner class Vh(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(position: Int) {
            itemView.txt_sher_nomi.text = list[position].name
            itemView.txt_sher_matni.text = list[position].matni
            if (list[position].like) {
                itemView.image_rv_saqlanganlar.setImageResource(R.drawable.ic_sher_saqlanganda)
            } else {
                itemView.image_rv_saqlanganlar.setImageResource(R.drawable.ic_love)
            }
            itemView.setOnClickListener {
                onRVClicked.onClick(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh =
        Vh(LayoutInflater.from(parent.context).inflate(R.layout.item_rv, parent, false))

    override fun onBindViewHolder(holder: Vh, position: Int) =
        holder.onBind(position)

    override fun getItemCount(): Int = list.size
}

interface OnRVClicked {
    fun onClick(position: Int)
}