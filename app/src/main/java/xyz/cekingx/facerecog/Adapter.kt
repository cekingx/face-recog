package xyz.cekingx.facerecog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list.view.*
import kotlinx.android.synthetic.main.list_item_3.view.*
import xyz.cekingx.facerecog.Entity.Riwayat

class Adapter(private val list:ArrayList<Riwayat>): RecyclerView.Adapter<Adapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.list_item_3,parent,false))
    }

    override fun getItemCount(): Int = list?.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.view.riwayatTinggal_text.text = list?.get(position)?.riwayat_tinggal
    }

    class Holder(val view: View) : RecyclerView.ViewHolder(view)
}