package com.example.it_department.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.it_department.R
import com.example.it_department.Models.ModelFaculty

class FacultyRecyclerViewAdapter(private val faculty: List<ModelFaculty>) : RecyclerView.Adapter<FacultyRecyclerViewAdapter.FacultyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FacultyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_faculty, parent, false)
        return FacultyViewHolder(view)
    }

    override fun onBindViewHolder(holder: FacultyViewHolder, position: Int) {
        val faculty = faculty[position]
        holder.bind(faculty)
    }

    override fun getItemCount(): Int {
        return faculty.size
    }

    class FacultyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val txtName = itemView.findViewById<TextView>(R.id.txtName)
        private val txtEmail = itemView.findViewById<TextView>(R.id.txtEmail)
        private val txtPhone = itemView.findViewById<TextView>(R.id.txtPhone)
        private val imgPhoto = itemView.findViewById<ImageView>(R.id.imgPhoto)

        fun bind(faculty: ModelFaculty) {
            txtName.text = faculty.FacultyName
            txtEmail.text = faculty.FacultyEmail
            txtPhone.text = faculty.FacultyPhone

            imgPhoto.load(faculty.FacultyPhoto) {
                placeholder(R.drawable.loading)
            }
        }
    }
}