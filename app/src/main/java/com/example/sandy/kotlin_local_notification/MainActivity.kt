package com.example.sandy.kotlin_local_notification

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      var lManager=getSystemService(Context.LOCATION_SERVICE) as LocationManager

        lManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,1000,1.toFloat(),
                object :LocationListener{

                    override fun onLocationChanged(location: Location?) {

                        textView.text = location!!.latitude.toString()
                        textView2.text = location!!.longitude.toString()
                    }

                    override fun onStatusChanged(p0: String?, p1: Int, p2: Bundle?) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onProviderEnabled(p0: String?) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onProviderDisabled(p0: String?) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                })

        //Local Notification

        var count=0

        button.setOnClickListener({
            var nManager = getSystemService(Context.NOTIFICATION_SERVICE)
                    as NotificationManager
            var nCompact = NotificationCompat.Builder(this@MainActivity,
                    "and7am_aug")
            nCompact.setTicker("Sample Notification Ticker ")
            nCompact.setSmallIcon(R.drawable.ic_local_car_wash_black_24dp)
            nCompact.setContentTitle("Sample Notification Title")
            nCompact.setContentText("This is a notification Text like message")
            nCompact.setAutoCancel(true)
            var i = Intent(this@MainActivity,
                    carwash::class.java)
            var pIntent = PendingIntent.getActivity(
                    this@MainActivity,0,i,0)
            nCompact.setContentIntent(pIntent)
            nManager.notify(++count,nCompact.build())
        })
    }
}
