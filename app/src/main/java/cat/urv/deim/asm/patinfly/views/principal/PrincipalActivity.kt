package cat.urv.deim.asm.patinfly.views.principal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import cat.urv.deim.asm.patinfly.R
import cat.urv.deim.asm.patinfly.views.profile.ProfileInfoActivity
import cat.urv.deim.asm.patinfly.views.login.LoginActivity

class PrincipalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.principal_activity)

        val botoCerrarSesion = this.findViewById<Button>(R.id.tancarSessio)
        botoCerrarSesion.setOnClickListener {
            val intento1 = Intent(this, LoginActivity::class.java)
            startActivity(intento1)
        }
        val botoDatosUsuario = this.findViewById<Button>(R.id.datosusuario)
        botoDatosUsuario.setOnClickListener {
            val intento2 = Intent(this, ProfileInfoActivity::class.java)
            startActivity(intento2)
        }
    }
}