package cat.urv.deim.asm.patinfly.views.tutorial

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import cat.urv.deim.asm.patinfly.R
import cat.urv.deim.asm.patinfly.views.login.LoginActivity

class TutorialActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.tutorial)


        val botoSiguiente = this.findViewById<Button>(R.id.siguiente)
        botoSiguiente.setOnClickListener{
            val intento = Intent(this, TutorialActivity2::class.java)
            startActivity(intento)
        }

        val botoInici=this.findViewById<Button>(R.id.inicio)
        botoInici.setOnClickListener {
           val intento = Intent(this, LoginActivity::class.java)
            startActivity(intento)
        }



    }


}