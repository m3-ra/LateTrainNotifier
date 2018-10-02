package com.jcros.latetrainnotifier.views

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.jcros.latetrainnotifier.R
import com.jcros.latetrainnotifier.database.MonitoredTrainsDatabase
import com.jcros.latetrainnotifier.databinding.ActivityMainBinding
import com.jcros.latetrainnotifier.viewModels.MainViewModel

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = MonitoredTrainsDatabase.getInstance(this)

        if (db != null)
            binding.vm = MainViewModel(this, db)
    }
}
