package nstda.or.th.thumbolkotlindemo

import android.content.Context
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.telephony.TelephonyManager
import android.util.Log
import kotlinx.android.synthetic.main.activity_image_view.*
import th.or.nectec.*

class ImageView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_view)


        val tv :TelephonyManager
        tv = getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager

        Log.d("dv_dump0", Build.FINGERPRINT)
        Log.d("dv_dump1", tv.networkOperatorName)
        Log.d("dv_dump2", tv.networkCountryIso)
        Log.d("dv_dump3", tv.simCountryIso)
        Log.d("dv_dump4", tv.simOperatorName)


    }

}
