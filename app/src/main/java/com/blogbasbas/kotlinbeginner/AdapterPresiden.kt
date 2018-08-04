package com.blogbasbas.kotlinbeginner

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.blogbasbas.kotlinbeginner.R.layout.item_list
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_list.view.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.startActivity

/**
 * Created by User on 03/08/2018.
 */
class AdapterPresiden (private  val ctx : Context,
                       private val modelItems : List<ModelItem>)
    : RecyclerView.Adapter<AdapterPresiden.ViewHolder>() {

    //method ini fungsinya untuk tempelating layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=
            ViewHolder(LayoutInflater.from(ctx).inflate(item_list,parent,false))

    //method ini fungsinya untuk set item yang telah di inisialisasi di call viewholder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(modelItems[position])

    }
    // method ini fungsinya untuk set jumlah item yang akan di tampilkan di list
    override fun getItemCount(): Int = modelItems.size


    //class viewholder untuk inisialisasi view dan widget di layout item_list
    class ViewHolder  (view : View) : RecyclerView.ViewHolder(view){

        fun bindItem(items: ModelItem) {
            // set data ke widget
            itemView.name_presiden.text = items.name
            Glide.with(itemView.context).load(items.img).into(itemView.image_presiden)
            println("get image ${items.img}")

           //event klik menggunakan anko
            itemView.cvList.onClick {
                it?.context?.startActivity<DetailActivity>(
                        "NAME" to items.name,
                        "IMG" to items.img,
                        "KE" to items.presiden
                        , "DETAIL" to items.detail
                )


            }

        }
    }

}




