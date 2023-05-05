package com.x7.jsonplaceholder_retrofitapi_postid

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.x7.jsonplaceholder_retrofitapi_postid.databinding.RecyclerviewItemBinding
import com.x7.jsonplaceholder_retrofitapi_postid.model.JsonPostIdModelItem

class JsonAdapter constructor(
    val context: Context,
    val arrayList: ArrayList<JsonPostIdModelItem>
):RecyclerView.Adapter<JsonAdapter.JsonViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JsonViewHolder {
        val view=RecyclerviewItemBinding.inflate(LayoutInflater.from(context),parent,false)
        return JsonViewHolder(view)
    }
    override fun onBindViewHolder(holder: JsonViewHolder, position: Int) {
        holder.binding.textview1.text=arrayList.get(position).name
    }

    override fun getItemCount(): Int =arrayList.size

    class JsonViewHolder (val  binding: RecyclerviewItemBinding):RecyclerView.ViewHolder(binding.root)


}