package com.jcros.latetrainnotifier.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query

@Dao
interface MonitoredTrainsDataDao {

    @Query("SELECT * from monitoredTrainsData")
    fun getAll(): List<MonitoredTrainsData>

    @Insert(onConflict = REPLACE)
    fun insert(monitoredTrainsData: MonitoredTrainsData)

    @Query("DELETE from monitoredTrainsData")
    fun deleteAll()
}