package cat.urv.deim.asm.patinfly

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class PrincipalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.principal_activity)

        val botoCerrarSesion = this.findViewById<Button>(R.id.tancarSessio)
        botoCerrarSesion.setOnClickListener {
            val intento1 = Intent(this, LoginActivity::class.java)
            startActivity(intento1)
        }
    }
}