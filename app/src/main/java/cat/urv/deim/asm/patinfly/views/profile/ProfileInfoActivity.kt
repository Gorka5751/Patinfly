package cat.urv.deim.asm.patinfly.views.profile

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import cat.urv.deim.asm.patinfly.R
import cat.urv.deim.asm.patinfly.models.UserRepository

import cat.urv.deim.asm.patinfly.views.signup.SignupActivity

class ProfileInfoActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_info);




        findViewById<TextView>(R.id.nomProfile).text = UserRepository.userGlobal.nom;
        findViewById<TextView>(R.id.Cognom).text = UserRepository.userGlobal.cognom;
        findViewById<TextView>(R.id.correu).text = UserRepository.userGlobal.correu;
        findViewById<TextView>(R.id.dniText).text = UserRepository.userGlobal.dni;
        findViewById<TextView>(R.id.telefon).text = UserRepository.userGlobal.telefon;
        findViewById<TextView>(R.id.nacio).text = UserRepository.userGlobal.nacionalitat;
        findViewById<TextView>(R.id.kilometres).text = UserRepository.userGlobal.Km;

        val botoCerrarSesion=this.findViewById<Button>(R.id.sesion)
        val botoCanviarDatos=this.findViewById<Button>(R.id.Datos)

        //Si el usuario se registra correctamente, se le llevara a la actividad principal, que es la
        //misma activity que entraria desde el login.

        botoCanviarDatos.setOnClickListener {
            val intento = Intent(this, SignupActivity::class.java)
            startActivity(intento)
        }

        


        println(UserRepository.userGlobal.cognom)

    }
    private fun showToast(context: Context = applicationContext, message: String, duration: Int){
        Toast.makeText(context,message,duration).show()
    }
}