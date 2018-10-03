package com.jcros.latetrainnotifier.viewHelpers

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.jcros.latetrainnotifier.database.MonitoredTrain
import com.jcros.latetrainnotifier.databinding.ItemTrainBinding

class TrainListAdapter(var trains: List<MonitoredTrain>) : RecyclerView.Adapter<TrainListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrainListViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val itemTrainBinding = ItemTrainBinding.inflate(layoutInflater, parent, false)
        return TrainListViewHolder(itemTrainBinding)
    }

    override fun onBindViewHolder(holder: TrainListViewHolder, position: Int) {

        val monitoredTrain = trains[position]
        holder.bind(monitoredTrain)
    }

    override fun getItemCount(): Int {

        return trains.size
    }
}