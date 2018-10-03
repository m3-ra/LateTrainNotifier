package com.jcros.latetrainnotifier.viewHelpers

import android.support.v7.widget.RecyclerView
import com.jcros.latetrainnotifier.database.MonitoredTrain
import com.jcros.latetrainnotifier.databinding.ItemTrainBinding

class TrainListViewHolder(private val binding: ItemTrainBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(train: MonitoredTrain) {

        binding.vm = train
        binding.executePendingBindings()
    }
}