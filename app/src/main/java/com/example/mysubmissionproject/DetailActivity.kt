package com.example.mysubmissionproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

@Suppress("DEPRECATION")
class DetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        @Suppress("DEPRECATION")
        val dataFoods = intent.getParcelableExtra<Foods>("key_foods")

        val tvDetailName: TextView = findViewById(R.id.tv_detail_name)
        val tvDetailDescription: TextView = findViewById(R.id.tv_detail_description)
        val ivDetailPhoto: ImageView = findViewById(R.id.iv_detail_photo)
        val btShare: Button = findViewById(R.id.action_share)
        val tvDetailOrigin: TextView = findViewById(R.id.tv_detail_origin)
        val tvDetailPrice: TextView = findViewById(R.id.tv_detail_price)

        tvDetailName.text = dataFoods?.name
        tvDetailDescription.text = dataFoods?.description
        ivDetailPhoto.setImageResource(dataFoods?.photo!!)
        tvDetailOrigin.text = dataFoods.origin
        tvDetailPrice.text = dataFoods.price

        btShare.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            val shareText = "Cek ${dataFoods.name} yuk, makanan khas Jawa Tengah yang enak banget!\n\n${dataFoods.description}"
            shareIntent.putExtra(Intent.EXTRA_TEXT, shareText)
            startActivity(Intent.createChooser(shareIntent, "Bagikan melalui"))
        }
    }


}

