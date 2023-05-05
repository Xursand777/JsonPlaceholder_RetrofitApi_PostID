package com.x7.jsonplaceholder_retrofitapi_postid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.x7.jsonplaceholder_retrofitapi_postid.databinding.ActivityMainBinding
import com.x7.jsonplaceholder_retrofitapi_postid.model.JsonPostIdModelItem
import com.x7.jsonplaceholder_retrofitapi_postid.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
     var arrayList= ArrayList<JsonPostIdModelItem>()
    lateinit var jsonAdapter: JsonAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener {
            requestquery()
        }


    }

    fun requestpath(){
        val call: Call<ArrayList<JsonPostIdModelItem>> =RetrofitInstance.api.getCountry(binding.edittext1.text.toString().toInt())
        call.enqueue(object :Callback<ArrayList<JsonPostIdModelItem>>{
            override fun onResponse(call: Call<ArrayList<JsonPostIdModelItem>>,response: Response<ArrayList<JsonPostIdModelItem>>) {
                if (response.isSuccessful){
                    arrayList=response.body()!!
                    Toast.makeText(this@MainActivity,"${arrayList.size}",Toast.LENGTH_SHORT).show()

                    binding.recyclerview1.layoutManager=LinearLayoutManager(this@MainActivity)
                    jsonAdapter = JsonAdapter(this@MainActivity,arrayList)
                    binding.recyclerview1.adapter=jsonAdapter
                }
            }

            override fun onFailure(call: Call<ArrayList<JsonPostIdModelItem>>, t: Throwable) {

            }

        })
    }

    fun requestquery(){
        val call:Call<ArrayList<JsonPostIdModelItem>> = RetrofitInstance.api.getCountry2(binding.edittext1.text.toString().toInt())
        call.enqueue(object :Callback<ArrayList<JsonPostIdModelItem>>{
            override fun onResponse(
                call: Call<ArrayList<JsonPostIdModelItem>>,
                response: Response<ArrayList<JsonPostIdModelItem>>
            ) {
                if (response.isSuccessful){
                    arrayList=response.body()!!

                    binding.recyclerview1.layoutManager=GridLayoutManager(this@MainActivity,2)
                    jsonAdapter = JsonAdapter(this@MainActivity,arrayList)
                    binding.recyclerview1.adapter=jsonAdapter

                }
            }

            override fun onFailure(call: Call<ArrayList<JsonPostIdModelItem>>, t: Throwable) {

            }

        })
    }
}