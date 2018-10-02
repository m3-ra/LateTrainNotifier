package com.jcros.latetrainnotifier.viewHelpers

import android.databinding.BindingAdapter
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Button
import com.jcros.latetrainnotifier.commands.ICommand
import com.jcros.latetrainnotifier.database.MonitoredTrainsData

@BindingAdapter("command")
fun bindButtonClick(button: Button, command: ICommand) {

    button.setOnClickListener { command.execute() }
}

@BindingAdapter("collection")
fun bindCollectionToRecyclerView(view: RecyclerView, collection: List<MonitoredTrainsData>) {

    if (view.layoutManager == null)
        view.layoutManager = LinearLayoutManager(view.context)

    if (view.adapter == null)
        view.adapter = TrainListAdapter(collection)

    (view.adapter as TrainListAdapter).notifyDataSetChanged()
}

@BindingAdapter("deleteItem")
fun deleteItemFromRecyclerView(view: RecyclerView, command: ICommand) {

    // TODO
}
