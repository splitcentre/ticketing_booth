package com.example.ticketing_booth

import android.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import com.example.ticketing_booth.databinding.ActivityPaymentBinding

class Payment : AppCompatActivity() {
    private lateinit var binding: ActivityPaymentBinding
    private lateinit var theater:Array<String>
    private lateinit var PaymentMethod: Array<String>
    private lateinit var seatlist:Array<String>
    var TotalPayment=0
    companion object{
        const val EXTRA_THEATER="extra_theater"
        const val EXTRA_SEAT="extra_seat"
        const val EXTRA_DATE="EXTRA_DATE"
        const val EXTRA_TIME="EXTRA_TIME"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val title=intent.getStringExtra("Title")
        val image= intent.getIntExtra("image",0)
        PaymentMethod= arrayOf(
            "Ticket Booth",
            "E-Money"
        )
        with(binding){
            val TheaterList=
                ArrayAdapter(this@Payment, R.layout.simple_spinner_dropdown_item,theater)
            TheaterList.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            theaterlist.adapter=TheaterList
            val SeatList=ArrayAdapter( this@Payment,android.R.layout.simple_spinner_dropdown_item,seatlist)
            SeatList.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            seat.adapter=SeatList

            print.setOnClickListener {
                val intent= Intent(this@Payment,OrderDetail::class.java)
                intent.putExtra("Title",title)
                intent.putExtra("Image",image)
                intent.putExtra(EXTRA_THEATER,theaterlist.selectedItem.toString())
                intent.putExtra(EXTRA_SEAT,seat.selectedItem.toString())
                startActivity(intent)
            }
        }
    }
}