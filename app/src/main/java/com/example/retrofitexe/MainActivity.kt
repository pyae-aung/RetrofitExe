package com.example.retrofitexe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitexe.adapter.FactAdapter
import com.example.retrofitexe.api.FactApi
import com.example.retrofitexe.model.Fact
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(), FactAdapter.ClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getFact()
    }

    fun setFact(list: List<Fact>) {
        val factAdapter = FactAdapter(list)
        recyclerFacts.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = factAdapter
        }
        factAdapter.mClickListener = this@MainActivity
    }

    fun getFact() {
        var baseUrl = "https://jsonplaceholder.typicode.com/"
        var retrofitBuilder = Retrofit
            .Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create()).build()
        var retrofitService = retrofitBuilder.create(FactApi::class.java)
        var apiCall = retrofitService.getFact()

        apiCall.enqueue(object : Callback<List<Fact>> {
            override fun onFailure(call: Call<List<Fact>>, t: Throwable) {

            }

            override fun onResponse(call: Call<List<Fact>>, response: Response<List<Fact>>) {
                var listFacts = response.body()
//                Log.d("Response>>>>>>", listFacts.toString()) //to check the data from api
                setFact(listFacts!!)
            }

        })
    }

    override fun onClick(fact: Fact) {
        var intent = Intent(this@MainActivity, FactActivity::class.java)
        intent.apply {
            putExtra("ID", fact.id)
            putExtra("TITLE", fact.title)
        }
        startActivity(intent)
    }
}
