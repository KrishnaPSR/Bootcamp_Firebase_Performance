package com.example.firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.perf.FirebasePerformance
import com.google.firebase.perf.metrics.AddTrace
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.RuntimeException

class MainActivity : AppCompatActivity() {
    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("onCreate","${intent.extras?.getString("custom_data")}")
    }*/
    val myTrace= FirebasePerformance.getInstance().newTrace("testTrace")

    @AddTrace(name = "onCreateTrace")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //crash
        button.setOnClickListener(){
            throw RuntimeException("Test Crash")
        }
        myFunction()
    }
    private fun myFunction() {
        myTrace.start()
        myTrace.incrementMetric("hit",1)



        myTrace.stop()
    }
}