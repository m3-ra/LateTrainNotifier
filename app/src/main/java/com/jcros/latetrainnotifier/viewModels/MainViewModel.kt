package com.jcros.latetrainnotifier.viewModels

import android.app.AlarmManager
import android.app.NotificationManager
import android.content.Context
import android.databinding.BaseObservable
import com.jcros.latetrainnotifier.commands.ICommand
import com.jcros.latetrainnotifier.commands.RelayCommand
import com.jcros.latetrainnotifier.database.MonitoredTrainsData
import com.jcros.latetrainnotifier.database.MonitoredTrainsDatabase
import com.jcros.latetrainnotifier.notifications.NotifierManager

class MainViewModel(@field:Transient val context: Context, val db: MonitoredTrainsDatabase) : BaseObservable() {

    val notificationManager: NotifierManager
    val addNewMonitoredTrainCommand: ICommand
    val deleteMonitoredTrain: ICommand
    var monitoredTrains = mutableListOf<MonitoredTrainsData>()
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
        //val newTrain = MonitoredTrain(newIdParsed)
        //monitoredTrains.add(0, newTrain)

        notificationManager.start(newIdParsed)

//        val content = ContentValues()
//        content.put("Id", newIdParsed)

//        context.database.use {
//            insert("MonitoredTrains", null, content)
//        }

        db?.monitoredTrainsDataDao()?.insert(MonitoredTrainsData(null, newId, "", ""))

        reloadDatabase()
    }

    private fun reloadDatabase() {

//        context.database.use {
//
//            val trainParser = classParser<MonitoredTrain>()
//            select("MonitoredTrains", "Id").exec {
//
//                monitoredTrains.clear()
//                monitoredTrains.addAll(parseList(trainParser))
//                monitoredTrains.reverse()
//            }
//        }

        val dbtrains = db.monitoredTrainsDataDao().getAll()

        monitoredTrains.clear()
        monitoredTrains.addAll(dbtrains)
        monitoredTrains.reverse()

        notifyChange()
    }

    private fun deleteTrain() {
    }

    private fun deleteTrain(id: Int) {

//        context.database.use {
//            delete("MonitoredTrains", "Id = {id}", "id" to id)
//        }

        reloadDatabase()
    }
}