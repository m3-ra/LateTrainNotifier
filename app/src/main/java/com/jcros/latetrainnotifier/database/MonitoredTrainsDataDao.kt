package com.jcros.latetrainnotifier.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query

@Dao
interface MonitoredTrainsDataDao {

    @Query("SELECT * from monitoredTrain")
    fun getAll(): List<MonitoredTrain>

    @Insert(onConflict = REPLACE)
    fun insert(monitoredTrain: MonitoredTrain)

    @Query("DELETE from monitoredTrain where id = :id")
    fun deleteById(id : Int)

    @Query("DELETE from monitoredTrain")
    fun deleteAll()
}