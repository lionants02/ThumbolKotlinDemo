package nstda.or.th.thumbolkotlindemo

import android.content.DialogInterface
import android.support.v7.app.AlertDialog
import android.widget.EditText
import android.widget.ImageView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_image_view.*
import th.or.nectec.ThumbolURL

/**
 * Created by max on 8/21/2017.
 */
class Controller (var createUrl: ThumbolURL,var appCompatActivity: nstda.or.th.thumbolkotlindemo.ImageView,var imageView: ImageView){
var outputValue :Int =0
    fun updateUI(){
        appCompatActivity.runOnUiThread {
            Glide.with(appCompatActivity)
                    .load(createUrl.createUrl())
                    .into(imageView);

        }
        appCompatActivity.tv_url.setText(createUrl.createUrl())
    }

    fun createDialog(title:String="Input", inputType: Int, okBody:(Int) -> Unit, cancelBody:() -> Unit={}, updateUI:Boolean = true){

        val builder = AlertDialog.Builder(appCompatActivity)
        builder.setTitle(title)
        val input = EditText(appCompatActivity)
        input.inputType = inputType// or InputType.TYPE_NUMBER_FLAG_DECIMAL
        builder.setView(input)
        builder.setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->
            var m_Text = input.text.toString()
            outputValue = if (m_Text.length > 0) m_Text.toInt() else 0
            okBody(outputValue)
            if (updateUI) updateUI()


            /*Log.d("my_dump",m_Text)
            createUrl.blur=m_Text.toInt()
            controller!!.updateUI()*/
        })
        builder.setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, which ->
            dialog.cancel()
            cancelBody()
            if (updateUI) updateUI()

           //
        })
        builder.show()

    }


}