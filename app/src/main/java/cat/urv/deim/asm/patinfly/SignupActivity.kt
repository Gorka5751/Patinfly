package cat.urv.deim.asm.patinfly

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity


class SignupActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.signup);





        val Nacionalidad = this.findViewById<Spinner>(R.id.spinnerNaciones)
        val lista = arrayOf("España", "Francia", "Alemania", "Wakanda","Suïssa")
        val nacionalitats = ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,lista);
        Nacionalidad.adapter = nacionalitats







        //AL CREAR UN NOU USUARI, GUARDAREM LA SEVA INFORMACIÓ DINS DE L'OBJECTE USERINFO.
        val botoCrear=this.findViewById<Button>(R.id.gorka)
        botoCrear.setOnClickListener {


            val Nombre = this.findViewById<EditText>(R.id.nombre).text.toString()
            val Apellido = this.findViewById<EditText>(R.id.apellido).text.toString()
            val Correo = this.findViewById<EditText>(R.id.correo).text.toString()
            val DNI = this.findViewById<EditText>(R.id.dni).text.toString()
            val Telefono = this.findViewById<EditText>(R.id.telefono).text.toString()
            val Kilometros = this.findViewById<EditText>(R.id.kilometros).text.toString()
            val Contraseña = this.findViewById<EditText>(R.id.passwordSignup).text.toString()








            val newUser = userInfo(Nombre,Apellido,Correo,Telefono,DNI,Nacionalidad.selectedItem.toString(),Kilometros,Contraseña);
            UserRepository.userGlobal = newUser;


            if(UserRepository.userGlobal.nom!="" && UserRepository.userGlobal.cognom!="" && UserRepository.userGlobal.correu!="" && UserRepository.userGlobal.dni!=""&& UserRepository.userGlobal.telefon!="" && UserRepository.userGlobal.Km!="" && UserRepository.userGlobal.nacionalitat!="" && UserRepository.userGlobal.contraseña!="" ){
                val intento1 = Intent(this, ProfileInfoActivity::class.java)
                startActivity(intento1)
            }else{

            }



        }



    }


}



