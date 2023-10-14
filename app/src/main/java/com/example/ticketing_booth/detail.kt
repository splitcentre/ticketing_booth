package com.example.ticketing_booth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.ticketing_booth.databinding.ActivityDetailBinding


class detail : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val title = intent.getStringExtra("Title")
        val description = intent.getStringExtra("Description")
        val image = intent.getIntExtra("Image_Movie",0)

        with(binding){
            Title.text = title
            words.text = description
            Glide.with(this@detail).load(image).into(pict)

            binding.btnNext.setOnClickListener {
                val intent = Intent(this@detail, Payment::class.java)
                intent.putExtra("Title",title)
                intent.putExtra("Image",image)
                startActivity(intent)
                finish()
            }

        }

    }
}