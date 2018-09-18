package com.jcros.latetrainnotifier.models

data class MonitoredTrain(val trainNumber: Int) {

    val title: String
        get() = trainNumber.toString()
}