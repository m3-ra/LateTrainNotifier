package com.jcros.latetrainnotifier.viewHelpers

import android.support.v7.widget.RecyclerView
import com.jcros.latetrainnotifier.database.MonitoredTrainsData
import com.jcros.latetrainnotifier.databinding.ItemTrainBinding

class TrainListViewHolder(private val binding: ItemTrainBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(train: MonitoredTrainsData) {

        binding.vm = train
        binding.executePendingBindings()
    }
}