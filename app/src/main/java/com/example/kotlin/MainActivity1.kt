package com.example.kotlin

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.AlarmClock
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity1 : AppCompatActivity() {
    lateinit var etName:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main1)
        etName = findViewById(R.id.etName)

        Log.i(TAG,  "im in oncreate")
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
         super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }
    override fun onOptionsItemSelected(mItem: MenuItem): Boolean {
        super.onOptionsItemSelected(mItem)
        when (mItem.itemId) {
            R.id.mi_settings -> {
                Toast.makeText(this, "opening settings", Toast.LENGTH_SHORT).show()
            }
            R.id.milogout -> {
                Toast.makeText(this, "logging out", Toast.LENGTH_SHORT).show()


            }


        }
        return true
    }




    fun clickHandler(view: View) {
        when (view.id) {
            R.id.btnLogin -> {
                startHomeActivity()
            }
            R.id.btnDial -> {
                startDialer()
            }
            R.id.btnAlarm -> {
                createAlarm("sync", 3, 20)
            }
        }

    }

    private fun startDialer() {
        var a = 10
        var b = a * 20;
        add(10,20)

        for(i in 1..10){
            var c = a * i
            var f = 30
            var z =  c + f

        }


        throw NullPointerException("dial ex")
        var dIntent = Intent(Intent.ACTION_DIAL, Uri.parse( "tel:123456"))
            startActivity(dIntent)
    }

    

    /**
     * this method adds 2 nos
     */
    private fun add(i: Int, i1: Int) {

    }


    private fun startHomeActivity() {
            Log.e(TAG, "click handler")

            var name = etName.text.toString()
            var hIntent = Intent(this, MainActivity::class.java)
            hIntent.putExtra("nkey", name)
            startActivity(hIntent)
        }
        fun createAlarm(message: String, hour: Int, minutes: Int) {
            val intent = Intent(AlarmClock.ACTION_SET_ALARM).apply {
                putExtra(AlarmClock.EXTRA_MESSAGE, message)
                putExtra(AlarmClock.EXTRA_HOUR, hour)
                putExtra(AlarmClock.EXTRA_MINUTES, minutes)
            }
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }

        companion object{
            var TAG = MainActivity::class.java.simpleName
        }


}








