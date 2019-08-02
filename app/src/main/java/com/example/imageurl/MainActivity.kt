package com.example.imageurl

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        LoadImage().execute("https://vcdn-thethao.vnecdn.net/2019/07/30/ro2-5325-1564473600.jpg")
    }

    inner class LoadImage : AsyncTask<String, Void, Bitmap>(){
        override fun doInBackground(vararg params: String?): Bitmap {
            val url = URL(params[0])
            val inputStream = url.openConnection().getInputStream()
            val bitmap : Bitmap = BitmapFactory.decodeStream(inputStream)

            return bitmap
        }

        override fun onPostExecute(result: Bitmap?) {
            super.onPostExecute(result)
            imgHinh.setImageBitmap(result)
        }
    }
}
