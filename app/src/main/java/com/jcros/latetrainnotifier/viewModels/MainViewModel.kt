package com.jcros.latetrainnotifier.viewModels

import android.app.AlarmManager
import android.app.NotificationManager
import android.content.Context
import android.databinding.BaseObservable
import com.jcros.latetrainnotifier.commands.ICommand
import com.jcros.latetrainnotifier.commands.RelayCommand
import com.jcros.latetrainnotifier.database.MonitoredTrain
import com.jcros.latetrainnotifier.database.MonitoredTrainsDatabase
import com.jcros.latetrainnotifier.notifications.NotifierManager

class MainViewModel(@field:Transient val context: Context, val db: MonitoredTrainsDatabase) : BaseObservable() {

    val notificationManager: NotifierManager
    val addNewMonitoredTrainCommand: ICommand
    val deleteMonitoredTrain: ICommand
    var monitoredTrains = mutableListOf<MonitoredTrain>()
    var newId: String = ""

    init {
        addNewMonitoredTrainCommand = RelayCommand { addNewMonitoredTrain() }
        deleteMonitoredTrain = RelayCommand { deleteTrain() }

        notificationManager = NotifierManager(context.getSystemService(Context.ALARM_SERVICE) as AlarmManager,
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager, context)

        reloadDatabase()
    }

    private fun addNewMonitoredTrain() {

        val newIdParsed = newId.toInt()
        notificationManager.start(newIdParsed)
        db.monitoredTrainsDataDao().insert(MonitoredTrain(null, newId, "", ""))
        reloadDatabase()
    }

    private fun reloadDatabase() {

        val dbtrains = db.monitoredTrainsDataDao().getAll()

        monitoredTrains.clear()
        monitoredTrains.addAll(dbtrains)
        monitoredTrains.reverse()

        notifyChange()
    }

    private fun deleteTrain() {
    }

    private fun deleteTrain(id: Int) {

        db.monitoredTrainsDataDao().deleteById(id)
        reloadDatabase()
    }
}