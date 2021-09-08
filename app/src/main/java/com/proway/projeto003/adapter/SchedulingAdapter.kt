//package com.proway.projeto003.adapter
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.recyclerview.widget.DiffUtil
//import androidx.recyclerview.widget.ListAdapter
//import androidx.recyclerview.widget.RecyclerView
//import com.proway.projeto003.R
//import com.proway.projeto003.databinding.SpecialityItemLayoutBinding
//import com.proway.projeto003.model.SchedulingPOJO
//
//class SchedulingAdapter(val onTap: (Int) -> Unit):
//    ListAdapter<SchedulingPOJO, SchedulingViewHolder>(SchedulingCheck()) {
//        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SchedulingViewHolder {
//            LayoutInflater.from(parent.context)
//                .inflate(R.layout.scheduling_item_layout, parent, false).apply {
//                    return SchedulingViewHolder(this)
//                }
//        }
//
//    override fun onBindViewHolder(holder: SchedulingViewHolder, position: Int) {
//        val item = getItem(position)
//        holder.bind(item)
//        holder.itemView.setOnClickListener { onTap(item.scheduling.id) }
//    }
//}
//
//class SchedulingCheck: DiffUtil.ItemCallback<SchedulingPOJO>() {
//    override fun areItemsTheSame(oldItem: SchedulingPOJO, newItem: SchedulingPOJO): Boolean {
//        return (oldItem.scheduling.id == newItem.scheduling.id) && (oldItem.doctor.id == newItem.doctor.id)
//    }
//
//    override fun areContentsTheSame(oldItem: SchedulingPOJO, newItem: SchedulingPOJO): Boolean {
//        return oldItem == newItem
//    }
//}
//
//class SchedulingViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
//
//    val binding = SpecialityItemLayoutBinding.bind(itemView)
//
//    fun bind(scheduling: SchedulingPOJO) {
//
//    }
//}