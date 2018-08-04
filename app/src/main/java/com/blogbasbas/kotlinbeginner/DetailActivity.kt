package com.blogbasbas.kotlinbeginner

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        //get data
        val namaPresiden = intent.getStringExtra("NAME")
        val imgPresiden = intent.getStringExtra("IMG")
        val kePresiden = intent.getStringExtra("KE")
        val detailPresiden = intent.getStringExtra("DETAIL")

        //set objek to textview
        tv_nama_presiden_detail.text = ("Nama Presiden : $namaPresiden")
        tv_presiden_ke_detail.text = ("Presiden Ke : $kePresiden")
        tv_detail_presiden.text = detailPresiden
        Glide.with(this).load(imgPresiden).into(img_detail)
    }
}
