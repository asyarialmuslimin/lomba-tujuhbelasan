package tech.saifurridho.lombatujuhbelasan.Adapter

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import tech.saifurridho.lombatujuhbelasan.DetailActivity
import tech.saifurridho.lombatujuhbelasan.Model.Lomba
import tech.saifurridho.lombatujuhbelasan.R

class LombaAdapter(private val list:ArrayList<Lomba>) : RecyclerView.Adapter<LombaAdapter.ListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, pos: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(parent: ListViewHolder, pos: Int) {
        val (title, deskripsi, gambar, video) = list[pos]
        Glide.with(parent.itemView.context)
            .load(gambar)
            .apply(RequestOptions().override(75,75))
            .into(parent.imgPhoto)
        parent.tvTitle.text = title
        parent.tvDesc.text = "${deskripsi.substring(0,200).replace("\n","")}..."
        parent.itemRows.setOnClickListener {
            val keDetail = Intent(parent.itemView.context, DetailActivity::class.java)
            keDetail.putExtra("TITLE", title)
            keDetail.putExtra("DESKRIPSI", deskripsi)
            keDetail.putExtra("GAMBAR" , gambar)
            keDetail.putExtra("VIDEO", video)
            parent.itemView.context.startActivity(keDetail)
        }
    }

    inner class ListViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {
        var tvTitle : TextView = itemView.findViewById(R.id.txtTitle)
        var tvDesc : TextView = itemView.findViewById(R.id.txtDesc)
        var imgPhoto : ImageView = itemView.findViewById(R.id.rvimage)
        var itemRows : RelativeLayout = itemView.findViewById(R.id.item_rows)
    }

}