package tech.saifurridho.lombatujuhbelasan

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    private lateinit var title:String
    private lateinit var deskripsi:String
    private lateinit var gambar:String
    private lateinit var video:String

    private lateinit var imgDetail:ImageView
    private lateinit var tvdTitle:TextView
    private lateinit var tvdDeskripsi:TextView
    private lateinit var btnVideo:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle("Detail")

        getData()
        initLayout()
    }

    override fun onSupportNavigateUp() : Boolean {
        finish()
        return true
    }

    private fun getData(){
        title = intent.getStringExtra("TITLE")
        deskripsi = intent.getStringExtra("DESKRIPSI")
        gambar = intent.getStringExtra("GAMBAR")
        video = intent.getStringExtra("VIDEO")
    }

    private fun initLayout(){
        imgDetail = findViewById(R.id.imgDetail)
        tvdTitle = findViewById(R.id.tvdTitle)
        tvdDeskripsi = findViewById(R.id.tvdDesc)
        btnVideo = findViewById(R.id.btnVideo)

        Glide.with(this)
            .load(gambar)
            .into(imgDetail)

        tvdTitle.text = title
        tvdDeskripsi.text = deskripsi
        btnVideo.setOnClickListener {
            goVideo(video)
        }

    }

    private fun goVideo(urlVideo:String){
        val intent = Intent(Intent.ACTION_VIEW)
        intent.setData(Uri.parse(urlVideo))
        startActivity(intent)
    }
}
