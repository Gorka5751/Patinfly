package cat.urv.deim.asm.patinfly.views.tutorial

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import cat.urv.deim.asm.patinfly.R
import cat.urv.deim.asm.patinfly.views.login.LoginActivity

class TutorialActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tutorial4)

        val botoSiguiente = this.findViewById<Button>(R.id.finalizar)
        botoSiguiente.setOnClickListener{
            val intento1 = Intent(this, LoginActivity::class.java)
            startActivity(intento1)
        }
        val botoAnterior = this.findViewById<Button>(R.id.atras3)
        botoAnterior.setOnClickListener{
            val intento1 = Intent(this, TutorialActivity3::class.java)
            startActivity(intento1)
        }
    }
}