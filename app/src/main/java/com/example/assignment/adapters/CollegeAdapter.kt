package com.example.assignment.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment.models.College
import com.example.assignment.R
import com.example.assignment.activities.CollegeDetailsActivity

/**
 * List of colleges  -> CollegeListAdapter
 */
class CollegeAdapter(private val context:Context, private val college: List<College>): RecyclerView.Adapter<CollegeAdapter.CollegeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollegeViewHolder {
           val inflater=LayoutInflater.from(parent.context)
        val view =inflater.inflate(R.layout.list_item1,parent,false)
        return CollegeViewHolder(view)
    }

    override fun onBindViewHolder(holder: CollegeViewHolder, position: Int) {
        holder.collegeName.text= college[position].name
        holder.collegeName.setOnClickListener {
            val intent = Intent(context, CollegeDetailsActivity::class.java)
            intent.putExtra("college",college[position].name)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return college.size
    }
    class CollegeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var collegeName: TextView =itemView.findViewById(R.id.collegeName)
    }
}




