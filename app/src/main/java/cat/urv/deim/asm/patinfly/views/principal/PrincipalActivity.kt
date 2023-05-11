package cat.urv.deim.asm.patinfly.views.principal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import cat.urv.deim.asm.patinfly.R
import cat.urv.deim.asm.patinfly.views.profile.ProfileInfoActivity
import cat.urv.deim.asm.patinfly.views.login.LoginActivity
import cat.urv.deim.asm.patinfly.views.scooter.ScootersListActivity

class PrincipalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.principal_activity)

        val botoCerrarSesion = this.findViewById<Button>(R.id.tancarSessio)
        botoCerrarSesion.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        val botoDatosUsuario = this.findViewById<Button>(R.id.datosusuario)
        botoDatosUsuario.setOnClickListener {
            val intent = Intent(this, ProfileInfoActivity::class.java)
            startActivity(intent)
        }
        val botoRentScooter = this.findViewById<Button>(R.id.RentScooter)
        botoRentScooter.setOnClickListener {
            val intent = Intent(this, ScootersListActivity::class.java)
            startActivity(intent)
        }
    }
}