package cat.urv.deim.asm.patinfly

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class TutorialActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tutorial3)

        val botoSiguiente = this.findViewById<Button>(R.id.siguiente3)
        botoSiguiente.setOnClickListener{
            val intento1 = Intent(this, TutorialActivity4::class.java)
            startActivity(intento1)
        }
        val botoAnterior = this.findViewById<Button>(R.id.atras2)
        botoAnterior.setOnClickListener{
            val intento1 = Intent(this, TutorialActivity2::class.java)
            startActivity(intento1)
        }
    }
}