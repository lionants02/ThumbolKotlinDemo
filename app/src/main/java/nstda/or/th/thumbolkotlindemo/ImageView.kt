package nstda.or.th.thumbolkotlindemo

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.telephony.TelephonyManager
import android.util.Log
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.httpGet
import kotlinx.android.synthetic.main.activity_image_view.*
import th.or.nectec.*
import java.io.File

class ImageView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_view)


       /* val tv :TelephonyManager
        tv = getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager

        Log.d("dv_dump0", Build.FINGERPRINT)
        Log.d("dv_dump1", tv.networkOperatorName)
        Log.d("dv_dump2", tv.networkCountryIso)
        Log.d("dv_dump3", tv.simCountryIso)
        Log.d("dv_dump4", tv.simOperatorName)*/




        Thread{
            kotlin.run {

                val createUrl :ThumbolURL = ThumbolURL("http://192.168.137.1:8000","1.jpg")
                createUrl.blur=5
                createUrl.blur_sigma=10
                createUrl.max_bytes=50000
                Log.d("my_dump",createUrl.createUrl())



                var data: ByteArray = kotlin.ByteArray(0)
                var url = createUrl.createUrl()
                url.httpGet().timeout(5000).timeoutRead(9000).response { request, response, result ->
                    Log.d("my_dump",""+response.httpStatusCode)
                    if (response.httpStatusCode == 200) {
                        data = result.get()
                        Log.d("my_dumpGGG",""+ (data?.size ?: -1) )
                        val bmp :Bitmap=BitmapFactory.decodeByteArray(data,0,data?.size ?: -1)

                        try {
                            runOnUiThread {
                                imageView.setImageBitmap(Bitmap.createScaledBitmap(bmp, imageView.width, imageView.height, false))
                            }
                            }catch (e :Exception){
                            Log.d("my_dump",e.message)
                        }
                    }
                }


                //Fuel.Companion.download(url).






                //val clientGetImage : ThumbolClient = ThumbolClient()

                //val imageData :ByteArray = clientGetImage.download(createUrl)!!

                //val sizeImage=if(data!=null) data!!.size else -1



            }
        }.start()

    }

}
