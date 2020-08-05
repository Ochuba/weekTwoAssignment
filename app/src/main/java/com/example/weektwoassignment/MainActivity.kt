package com.example.weektwoassignment

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentActivity

var countPotrait: Int = 0
var countLandscape: Int = 0

class MainActivity : AppCompatActivity() {
    var bundle: Bundle = Bundle()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("count", "$countLandscape and $countPotrait")

        if (savedInstanceState != null){ // checks whether there is a previous saved instance
            countPotrait = savedInstanceState.getInt("countPotrait")
            countLandscape =  savedInstanceState.getInt("countLandscape")
            updatetextViews()
            Log.d("count", "something has been passed")
        }
         var next = findViewById<Button>(R.id.second_activity)

        next.setOnClickListener{
            var intent = Intent(this, fragmentActivity::class.java)

            startActivity(intent)
        }
        var c = Runnable {
            updatetextViews("ONCREATE")
        }
        var hand = Handler()

        hand.postDelayed(c, 3000)


    }

        // updates the textview of the the potrait and landscape counter
    fun updatetextViews(state: String = "onResume"){
        var counterPotrait = findViewById<TextView>(R.id.count_potrait)
        var counterLandscape = findViewById<TextView>(R.id.count_landscape)
        var activityState = findViewById<TextView>(R.id.activity_state)


        counterPotrait.text ="Potrait: ${countPotrait}"
        counterLandscape.text ="Landscape: ${countLandscape}"
            activityState.text = state

    }

    override fun onStart() {
        super.onStart()
         var c = Runnable {
             updatetextViews("OnStart")
         }

        var hand = Handler()

        hand.postDelayed(c, 4000)

    }
    override fun onResume() {
        super.onResume()
          var c = Runnable {
              updatetextViews("OnResume")
          }

        var hand = Handler()

        hand.postDelayed(c, 5000)
    }
    override fun onPause() {
        super.onPause()
         var c = Runnable {
             updatetextViews("OnPause")
         }
        var hand = Handler()
        hand.postDelayed(c, 2000)

    }
    override fun onStop() {
        super.onStop()
         var c = Runnable {
             updatetextViews("OnStop")
         }
           var hand = Handler()
        hand.postDelayed(c, 3000)
    }
    override fun onDestroy() {
        super.onDestroy()
           var c = Runnable {
               updatetextViews("OnDestroy")
           }
          var hand = Handler()

        hand.postDelayed(c, 4000)

    }
    override fun onRestart() {
        super.onRestart()
          var c = Runnable {
              updatetextViews("OnRestart")
          }
       var hand = Handler()
        hand.postDelayed(c, 5000)

    }
    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)

        // Checks the orientation of the screen
        if (newConfig.orientation === Configuration.ORIENTATION_LANDSCAPE) {
            countLandscape++

            updatetextViews()
            Log.d("count", "landscape: $countLandscape")
        } else if (newConfig.orientation === Configuration.ORIENTATION_PORTRAIT) {
          countPotrait++

           updatetextViews()
            Log.d("count", "landscape: $countPotrait")


        }
    }

    // save the state of my activity before it is destroyed
    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putInt("countPotrait", countPotrait)
        outState.putInt("countLandscape", countLandscape)

    }





}