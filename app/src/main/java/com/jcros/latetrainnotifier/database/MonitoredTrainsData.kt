package com.jcros.latetrainnotifier.database

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "monitoredTrainsData")
data class MonitoredTrainsData(@PrimaryKey(autoGenerate = true) var id: Int?,
                               @ColumnInfo(name = "title") var title: String,
                               @ColumnInfo(name = "departureStation") var departureStation: String,
                               @ColumnInfo(name = "arrivalStation") var arrivalStation: String) {

    constructor() : this(null, "", "", "")
}