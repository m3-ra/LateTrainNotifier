package com.jcros.latetrainnotifier.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = [MonitoredTrain::class], version = 1)
abstract class MonitoredTrainsDatabase : RoomDatabase() {

    abstract fun monitoredTrainsDataDao(): MonitoredTrainsDataDao

    companion object {
        private var INSTANCE: MonitoredTrainsDatabase? = null

        fun getInstance(context: Context): MonitoredTrainsDatabase? {
            if (INSTANCE == null) {
                synchronized(MonitoredTrainsDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext, MonitoredTrainsDatabase::class.java, "monitoredTrains.db")
                            .allowMainThreadQueries() // TODO questionable but will do for now
                            .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}