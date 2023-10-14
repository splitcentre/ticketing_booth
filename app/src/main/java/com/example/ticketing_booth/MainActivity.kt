package com.example.ticketing_booth


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.ticketing_booth.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var MovieRecyclerView:RecyclerView
    private lateinit var list: ArrayList<movies>
    lateinit var imageId: Array<Int>
    lateinit var title:Array<String>
    lateinit var description: Array<String>
    lateinit var cast:List<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        imageId= arrayOf(
            R.drawable.drive ,
            R.drawable.hot_fuzz,
            R.drawable.prisoner,
            R.drawable.shin,
        )
        title=resources.getStringArray(R.array.title)
        description=resources.getStringArray(R.array.description)
        MovieRecyclerView=findViewById(R.id.movies_recycler)

        list= arrayListOf<movies>()
        getData()
        val username= intent.getStringExtra(login.EXTRA_NAME)
        binding.nama.text="$username"
    }
    private fun getData(){
        for (i in imageId.indices){

            val movies = movies(imageId[i],title[i],description[i])
            list.add(movies)
        }

        val adapter=MovieAdapter(list)
        MovieRecyclerView.adapter= adapter
    }
}
