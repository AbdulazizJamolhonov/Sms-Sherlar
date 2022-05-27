package developer.abdulaziz.smssherlar

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        smsDialog(this)
    }

    override fun onSupportNavigateUp(): Boolean {
        return Navigation.findNavController(this, R.id.my_container).navigateUp()
    }

    companion object {
        lateinit var dialog: AlertDialog
        fun smsDialog(context: Context) {
            val alertDialog = AlertDialog.Builder(context, R.style.NewDialog)
            dialog = alertDialog.create()

            val dialogView =
                LayoutInflater.from(context).inflate(R.layout.dialog_sms_logo, null, false)
            dialog.setView(dialogView)

            dialog.show()
            SmsDialog().start()
        }

        fun dialogCancel() {
            dialog.cancel()
        }
    }
}

class SmsDialog : Thread() {
    override fun run() {
        super.run()
        sleep(3000)
        MainActivity.dialogCancel()
    }
}