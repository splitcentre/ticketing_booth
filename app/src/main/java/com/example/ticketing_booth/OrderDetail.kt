package com.example.ticketing_booth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ticketing_booth.databinding.ActivityOrderDetailBinding

class OrderDetail : AppCompatActivity() {
    private lateinit var binding: ActivityOrderDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityOrderDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val title=intent.getStringExtra("Title")
        val image=intent.getIntExtra("Image",0)
        val Date=intent.getStringExtra(Payment.EXTRA_DATE)
        val Time=intent.getStringExtra(Payment.EXTRA_TIME)
        val Seat=intent.getStringExtra(Payment.EXTRA_SEAT)
        val Bioskop=intent.getStringExtra(Payment.EXTRA_THEATER)


        with(binding){
            tvBioskop.text=Bioskop
            dateMovie.text=Date+" "+Time
            seat.text=Seat
            imageMovie.setImageResource(image)
        }
    }
}