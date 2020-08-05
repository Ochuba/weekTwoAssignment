package com.example.weektwoassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.Toast
import androidx.fragment.app.FragmentManager

class fragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
       var fragmentManager = supportFragmentManager


        var fragOne = FragmentOne()
        var fragTwo = FragmentTwo()
        var fragThree = FragmentThree()

        var count = 1;
        val arg = Bundle()



        // get the views from the layout
        var remove = findViewById<Button>(R.id.removeFragment)
        var add = findViewById<Button>(R.id.addFragment)
        var frame = findViewById<FrameLayout>(R.id.frame)

        add.setOnClickListener {

          var tempTransaction =   fragmentManager.beginTransaction()
            when(count){
                1 ->  tempTransaction.add(R.id.frame, fragOne).addToBackStack(null).commit()
                2 -> tempTransaction.add(R.id.frame, fragTwo).addToBackStack(null).commit()
                3 -> tempTransaction.add(R.id.frame, fragThree).addToBackStack(null).commit()

            }
            arg.putInt("tis", count)
            fragTwo.arguments = arg
            fragThree.arguments = arg
            count++
           if (count > 3){
            Toast.makeText(applicationContext, "Fragment limit has been exceeded", Toast.LENGTH_SHORT).show()

             }
        }

        remove.setOnClickListener {
            var tempTransaction =   fragmentManager.beginTransaction()
            if (count > 4){
                count = 4
            }
            when(count){
                2 ->  tempTransaction.remove(fragOne).commit()
                3 -> tempTransaction.remove(fragTwo).commit()
                4 -> tempTransaction.remove(fragThree).commit()
            }
            Log.d("remove", "$count what we want")
            arg.putInt("tis", count)  //Put the value of count in a bundle
            fragOne.arguments = arg
            fragTwo.arguments = arg
            fragThree.arguments = arg


            count--
            if (count < 1){
                count = 1
            }
        }



    }
}