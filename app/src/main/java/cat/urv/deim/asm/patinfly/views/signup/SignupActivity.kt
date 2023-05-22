package cat.urv.deim.asm.patinfly.views.signup

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import cat.urv.deim.asm.patinfly.R
import cat.urv.deim.asm.patinfly.models.UserRepository
import cat.urv.deim.asm.patinfly.views.login.LoginInteractor
import cat.urv.deim.asm.patinfly.views.login.LoginPresenter
import cat.urv.deim.asm.patinfly.views.login.LoginView

import cat.urv.deim.asm.patinfly.views.scooter.ScootersListActivity


class SignupActivity: AppCompatActivity(), LoginView {

    private val presenter = LoginPresenter(this, LoginInteractor())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.signup)

        //Cuando el usuario quiere modificar los datos, rellenaremos los campos con la informacion ya añadida para que no tenga que ponerlo toodo otra vez

        if(UserRepository.userGlobal.nom!="" && UserRepository.userGlobal.cognom!="" && UserRepository.userGlobal.correu!="" && UserRepository.userGlobal.dni!=""&& UserRepository.userGlobal.telefon!="" && UserRepository.userGlobal.Km!="") {
            this.findViewById<TextView>(R.id.nombre).text = UserRepository.userGlobal.nom
            this.findViewById<TextView>(R.id.apellido).text = UserRepository.userGlobal.cognom
            this.findViewById<TextView>(R.id.correo).text = UserRepository.userGlobal.correu

            this.findViewById<TextView>(R.id.dni).text = UserRepository.userGlobal.dni
            this.findViewById<TextView>(R.id.telefono).text = UserRepository.userGlobal.telefon
            this.findViewById<TextView>(R.id.kilometros).text = UserRepository.userGlobal.Km
        }





        val nacionalidad = this.findViewById<Spinner>(R.id.spinnerNaciones)
        val lista = arrayOf("España", "Francia", "Alemania", "Wakanda","Suïssa")
        val nacionalitats = ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,lista)
        nacionalidad.adapter = nacionalitats







        //AL CREAR UN NOU USUARI, GUARDAREM LA SEVA INFORMACIÓ DINS DE L'OBJECTE USERINFO.
        val botoCrear=this.findViewById<Button>(R.id.gorka)
        this.hideProgress()
        botoCrear.setOnClickListener {
            this.showProgress()


            val nombre = this.findViewById<EditText>(R.id.nombre).text.toString()
            val apellido = this.findViewById<EditText>(R.id.apellido).text.toString()
            val correo = this.findViewById<EditText>(R.id.correo).text.toString()
            val dNI = this.findViewById<EditText>(R.id.dni).text.toString()
            val telefono = this.findViewById<EditText>(R.id.telefono).text.toString()
            val kilometros = this.findViewById<EditText>(R.id.kilometros).text.toString()
            val contrasena = this.findViewById<EditText>(R.id.passwordSignup).text.toString()








            UserRepository.createUser(nombre,apellido,correo,telefono,dNI,nacionalidad.selectedItem.toString(),kilometros,contrasena)



            if(UserRepository.userGlobal.nom!="" && UserRepository.userGlobal.cognom!="" && UserRepository.userGlobal.correu!="" && UserRepository.userGlobal.dni!=""&& UserRepository.userGlobal.telefon!="" && UserRepository.userGlobal.Km!="" && UserRepository.userGlobal.nacionalitat!="" && UserRepository.userGlobal.contraseña!="" ){
                navigateToProfile()
            }else{
                showToast(applicationContext,"Todos los campos son necessarios",10)
            }



        }



    }

    override fun onStart() {
        super.onStart()
    }

    override fun showProgress() {
        this.findViewById<ProgressBar>(R.id.progressSignup).visibility = View.VISIBLE
    }

    override fun hideProgress() {
        this.findViewById<ProgressBar>(R.id.progressSignup).visibility = View.INVISIBLE
    }

    @SuppressLint("SetTextI18n")
    override fun setUsernameError() {
        showToast(applicationContext,"Error al introducir usuario",10)
    }

    @SuppressLint("SetTextI18n")
    override fun setPasswordError() {
        showToast(applicationContext,"Error al introducir contraseña",10)
    }

    override fun navigateToProfile() {
        val intent = Intent()
        intent.setClass(this, ScootersListActivity::class.java)
        this.startActivity(intent)
    }
    private fun showToast(context: Context = applicationContext, message: String, duration: Int){
        Toast.makeText(context,message,duration).show()
    }

}



