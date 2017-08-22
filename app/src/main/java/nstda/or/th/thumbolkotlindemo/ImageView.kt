package nstda.or.th.thumbolkotlindemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.annotation.GlideModule
import kotlinx.android.synthetic.main.activity_image_view.*
import th.or.nectec.*
import android.text.InputType


@GlideModule
class ImageView : AppCompatActivity() {

    val createUrl :ThumbolURL = ThumbolURL("http://192.168.137.1:8000","1.jpg")
    //var m_Text :String = ""
    //var controller :Controller?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_view)

        var controller :Controller  =Controller(createUrl,this,imageView)
        controller.updateUI()
        /* val tv :TelephonyManager
         tv = getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager

         Log.d("dv_dump0", Build.FINGERPRINT)
         Log.d("dv_dump1", tv.networkOperatorName)
         Log.d("dv_dump2", tv.networkCountryIso)
         Log.d("dv_dump3", tv.simCountryIso)
         Log.d("dv_dump4", tv.simOperatorName)*/




        /*

        Thread{
            kotlin.run {


                createUrl.blur=5
                createUrl.blur_sigma=10
                //createUrl.max_bytes=50000
                Log.d("my_dump",createUrl.createUrl())
                var url = createUrl.createUrl()

                runOnUiThread {
                    Glide.with(this)
                            .load(createUrl.createUrl())
                            .into(imageView);

                }




            }
        }.start()

*/

        b_blur.setOnClickListener {
            controller.createDialog("Blur", InputType.TYPE_CLASS_NUMBER, { createUrl.blur = it
                controller.createDialog("Blur Sigma", InputType.TYPE_CLASS_NUMBER, { createUrl.blur_sigma = it
                })
            },updateUI = false)
        }
        b_brightness.setOnClickListener {
            controller.createDialog("Brightness", InputType.TYPE_CLASS_NUMBER, { createUrl.brightness = it })
        }

        b_contrast.setOnClickListener {
            controller.createDialog("Contrast", InputType.TYPE_CLASS_NUMBER, { createUrl.contrast = it })
        }


        b_equalize.setOnClickListener {
            controller.createDialog("Equalize", InputType.TYPE_CLASS_NUMBER, { createUrl.equalize = true }, { createUrl.equalize = false })
        }
        b_grayscale.setOnClickListener {
            controller.createDialog("Grayscale", InputType.TYPE_CLASS_NUMBER, { createUrl.grayscale = true }, { createUrl.grayscale = false })

        }
        b_rotate.setOnClickListener {
            controller.createDialog("Rotate", InputType.TYPE_CLASS_NUMBER, { createUrl.rotate = it })
        }

        b_rgb_amount.setOnClickListener(){
            controller.createDialog("RGB Amount Red", InputType.TYPE_CLASS_NUMBER, { createUrl.rgb_amount.rAmount = it
                controller.createDialog("RGB Amount Green", InputType.TYPE_CLASS_NUMBER, { createUrl.rgb_amount.gAmount = it
                    controller.createDialog("RGB Amount Blur", InputType.TYPE_CLASS_NUMBER, { createUrl.rgb_amount.bAmount = it
                    })
                },updateUI = false)
            },updateUI = false)
        }



        b_noise.setOnClickListener {
            controller.createDialog("Noise", InputType.TYPE_CLASS_NUMBER, { createUrl.noise = it })
        }


    }

}
