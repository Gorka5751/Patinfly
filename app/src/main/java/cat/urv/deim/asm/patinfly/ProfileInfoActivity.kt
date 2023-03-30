package cat.urv.deim.asm.patinfly

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileInfoActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_info);
        val userRepository = UserRepository();

        if(UserRepository.userGlobal.nom!="" && UserRepository.userGlobal.cognom!="" && UserRepository.userGlobal.correu!="" && UserRepository.userGlobal.dni!=""&& UserRepository.userGlobal.telefon!="" && UserRepository.userGlobal.Km!="" && UserRepository.userGlobal.nacionalitat!=""){
            findViewById<TextView>(R.id.nomProfile).text = UserRepository.userGlobal.nom;
            findViewById<TextView>(R.id.Cognom).text = UserRepository.userGlobal.cognom;
            findViewById<TextView>(R.id.correu).text = UserRepository.userGlobal.correu;
            findViewById<TextView>(R.id.dniText).text = UserRepository.userGlobal.dni;
            findViewById<TextView>(R.id.telefon).text = UserRepository.userGlobal.telefon;
            findViewById<TextView>(R.id.nacio).text = UserRepository.userGlobal.nacionalitat;
            findViewById<TextView>(R.id.kilometres).text = UserRepository.userGlobal.Km;
        }else{
            val intento1 = Intent(this, SignupActivity::class.java)
            startActivity(intento1)
        }

        val botoCerrarSesion=this.findViewById<Button>(R.id.sesion)
        val botoCanviarDatos=this.findViewById<Button>(R.id.Datos)

        botoCerrarSesion.setOnClickListener{
            val intento2 = Intent(this, LoginActivity::class.java)
            startActivity(intento2)
        }
        botoCanviarDatos.setOnClickListener {
            val intento3 = Intent(this, SignupActivity::class.java)
            startActivity(intento3)
        }

        


        println(UserRepository.userGlobal.cognom)

    }
}