package com.jcros.latetrainnotifier.viewHelpers

import android.support.v7.widget.RecyclerView
import com.jcros.latetrainnotifier.databinding.ItemTrainBinding
import com.jcros.latetrainnotifier.models.MonitoredTrain

class TrainListViewHolder(private val binding: ItemTrainBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(train: MonitoredTrain) {

        binding.vm = train
        binding.executePendingBindings()
    }
}