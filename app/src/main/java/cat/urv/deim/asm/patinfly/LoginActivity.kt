package cat.urv.deim.asm.patinfly

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class LoginActivity: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginEmailEditTest = this.findViewById<EditText>(R.id.loginEmailEditText)

        this.findViewById<EditText>(R.id.textEmail)
    }

    override fun onStart() {
        super.onStart()
    }
}