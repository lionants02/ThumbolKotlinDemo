package nstda.or.th.thumbolkotlindemo

import android.content.DialogInterface
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.text.InputType
import android.widget.EditText
import android.widget.ImageView
import com.bumptech.glide.Glide
import th.or.nectec.ThumbolURL
import java.util.concurrent.locks.Lock

/**
 * Created by max on 8/21/2017.
 */
class Controller (var createUrl: ThumbolURL,var appCompatActivity: nstda.or.th.thumbolkotlindemo.ImageView,var imageView: ImageView){
var outputValue :Int =0
    fun UpdateUI(){
        appCompatActivity.runOnUiThread {
            Glide.with(appCompatActivity)
                    .load(createUrl.createUrl())
                    .into(imageView);

        }
    }



    fun createDialog(title:String="Input", inputType: Int, okBody:() -> Unit, cancelBody:() -> Unit={}){

        val builder = AlertDialog.Builder(appCompatActivity)
        builder.setTitle("Blur Function")
        val input = EditText(appCompatActivity)
        input.inputType = inputType// or InputType.TYPE_NUMBER_FLAG_DECIMAL
        builder.setView(input)
        builder.setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which -> var m_Text = input.text.toString()


            outputValue=if(m_Text.length>0) m_Text.toInt() else 0
            okBody()
            UpdateUI()

            /*Log.d("my_dump",m_Text)
            createUrl.blur=m_Text.toInt()
            controller!!.UpdateUI()*/
        })
        builder.setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, which -> dialog.cancel()
        cancelBody()
        UpdateUI()
        })
        builder.show()

    }







    fun blueUpdate(blurValue:Int){
        appCompatActivity.createUrl.blur=blurValue
    }


}