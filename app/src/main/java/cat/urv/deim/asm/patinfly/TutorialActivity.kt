package cat.urv.deim.asm.patinfly

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class TutorialActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.tutorial)


        val botoSiguiente = this.findViewById<Button>(R.id.siguiente)
        botoSiguiente.setOnClickListener{
            val intento1 = Intent(this, TutorialActivity2::class.java)
            startActivity(intento1)
        }

        val botoInici=this.findViewById<Button>(R.id.inicio)
        botoInici.setOnClickListener {
           val intento1 = Intent(this, LoginActivity::class.java)
            startActivity(intento1)
        }



    }


}