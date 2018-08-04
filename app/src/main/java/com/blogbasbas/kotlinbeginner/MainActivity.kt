package com.blogbasbas.kotlinbeginner

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import com.blogbasbas.kotlinbeginner.R.array.*

class MainActivity : AppCompatActivity() {
    //variabel modelitems
    private var modelItems :MutableList<ModelItem> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initDataPresiden();
        //inisialisasi recyclerview
        rv_presiden.layoutManager = LinearLayoutManager(this)
        rv_presiden.adapter = AdapterPresiden(this,modelItems )

    }

    private fun initDataPresiden() {
        //buat objek array
        val namaPresiden = resources.getStringArray(nama_presiden)
        val gambar = resources.getStringArray(gambar_presiden)
        val presidenKe = resources.getStringArray(periode)
        val detail = resources.getStringArray(detail_presiden)

        //clear model
        modelItems.clear()
        //buat perulangan untuk set di recylerview
        for (i in namaPresiden.indices){
            modelItems.add(ModelItem(namaPresiden[i],
                    gambar[i],
                    presidenKe[i], detail[i]))
        }

    }
}
