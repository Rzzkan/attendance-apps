package com.example.attendanceapp.views.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.attendanceapp.R
import com.example.attendanceapp.model.GajiModel

class GajiAdapter() : RecyclerView.Adapter<GajiAdapter.viewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback
    private val list = ArrayList<GajiModel>()

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    class viewHolder(view: View):RecyclerView.ViewHolder(view){
        var tvMonth: TextView = view.findViewById(R.id.tvMonth)
        var tvMain: TextView = view.findViewById(R.id.tvMain)
        var tvOvertime: TextView = view.findViewById(R.id.tvOvertime)
        var tvBonus: TextView = view.findViewById(R.id.tvBonus)
        var tvDeduction: TextView = view.findViewById(R.id.tvDeduction)
        var tvSalary: TextView = view.findViewById(R.id.tvSalary)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val data = list[position]
        holder.tvMonth.text = data.bulan
        holder.tvMain.text = "Rp. ${data.gaji_pokok}"
        holder.tvOvertime.text = "Rp. ${data.gaji_lembur}"
        holder.tvBonus.text = "Rp. ${data.gaji_bonus}"
        holder.tvDeduction.text = "Rp. ${data.potongan}"
        holder.tvSalary.text = "Rp. ${data.gaji_diterima}"
        holder.itemView.setOnClickListener{
            onItemClickCallback.onItemClicked(holder.itemView,list[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int = list.size

    interface OnItemClickCallback {
        fun onItemClicked(view: View, data: GajiModel)
    }

    fun setArrayList(value: ArrayList<GajiModel>) {
        list.clear()
        list.addAll(value)
        notifyDataSetChanged()
    }
}