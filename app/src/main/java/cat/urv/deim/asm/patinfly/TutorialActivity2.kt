package cat.urv.deim.asm.patinfly

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class TutorialActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tutorial2);


        val botoSiguiente = this.findViewById<Button>(R.id.siguiente2)
        botoSiguiente.setOnClickListener{
            val intento1 = Intent(this, TutorialActivity3::class.java)
            startActivity(intento1)
        }
        val botoAnterior = this.findViewById<Button>(R.id.atras)
        botoAnterior.setOnClickListener{
            val intento1 = Intent(this, TutorialActivity::class.java)
            startActivity(intento1)
        }


    }
}