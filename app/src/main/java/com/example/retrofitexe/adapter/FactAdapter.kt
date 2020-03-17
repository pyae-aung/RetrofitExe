package com.example.retrofitexe.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitexe.R
import com.example.retrofitexe.model.Fact
import kotlinx.android.synthetic.main.item_fact.view.*

class FactAdapter(private val listFacts: List<Fact>) : RecyclerView.Adapter<FactAdapter.FactViewHolder>() {
    var mClickListener: ClickListener? = null

    inner class FactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private lateinit var fact: Fact
        init {
            itemView.setOnClickListener(this)
        }

        fun bind(fact: Fact) {
            this.fact = fact
            itemView.txtFactId.text = fact.id
        }

        override fun onClick(itemView: View?) {
            mClickListener?.onClick(fact)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FactViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_fact, parent, false)
        return FactViewHolder(view)
    }

    override fun getItemCount(): Int = listFacts.size

    override fun onBindViewHolder(holder: FactViewHolder, position: Int) {
        holder.bind(listFacts[position])
    }

    interface ClickListener {
        fun onClick(fact: Fact)
    }
}