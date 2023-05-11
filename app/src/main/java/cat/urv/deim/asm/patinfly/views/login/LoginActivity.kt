package cat.urv.deim.asm.patinfly.views.login

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle

import android.view.View

import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import cat.urv.deim.asm.patinfly.R
import cat.urv.deim.asm.patinfly.models.UserRepository
import cat.urv.deim.asm.patinfly.utils.postDelayed
import cat.urv.deim.asm.patinfly.views.principal.PrincipalActivity
import cat.urv.deim.asm.patinfly.views.scooter.ScootersListActivity
import cat.urv.deim.asm.patinfly.views.signup.SignupActivity
import cat.urv.deim.asm.patinfly.views.tutorial.TutorialActivity


class LoginActivity : AppCompatActivity(), LoginView {
    private val presenter = LoginPresenter(this, LoginInteractor())





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        //Mostrem la splashscreen durant 3 segons i despres passa a la login view on podrem iniciar sessio o registrar
        setContentView(R.layout.splashscreen)
        postDelayed(3000){
            setContentView(R.layout.activity_main)
            this.hideProgress()
            val loginEmailEditText = this.findViewById<EditText>(R.id.textEmail)
            val loginPasswordEditText = this.findViewById<EditText>(R.id.textPassword)
            val loginSignInButton = this.findViewById<Button>(R.id.LogIn)
            loginSignInButton.setOnClickListener {
                this.showProgress()
                val email: String = loginEmailEditText.text.toString()
                val password: String = loginPasswordEditText.text.toString()
                //Comprovem que el email i la contrasenya que posa lusuari es la mateixa que s'ha guardat a la varibale global durant el signup
                if(email.equals(UserRepository.userGlobal.correu) && email!="" && password!=""){
                    if(password.equals(UserRepository.userGlobal.contraseña)){
                        this.hideProgress()
                        showToast(applicationContext,"Has iniciado sesion correctamente",10)
                        navigateToProfile()
                    }else{
                        setPasswordError()
                    }
                }else{
                    setUsernameError()
                }
            }
            //Quan es pulsa el boto aquest, ens porta cap al tutorial
            val botoTutorial=this.findViewById<Button>(R.id.Tutorial1)
            botoTutorial.setOnClickListener {
                val intento1 = Intent(this, TutorialActivity::class.java)
                startActivity(intento1)
            }
            //Quan es pulsa aquest boto, ens porta a la pagina de signup per crear usuari
            val botoSignIn=this.findViewById<Button>(R.id.SignIn)
            botoSignIn.setOnClickListener {
                val intento2 = Intent(this, SignupActivity::class.java)
                startActivity(intento2)
            }


        }










    }


    override fun onStart() {
        super.onStart()
    }

    override fun showProgress() {
        this.findViewById<ProgressBar>(R.id.progress).visibility = View.VISIBLE
    }

    override fun hideProgress() {
        this.findViewById<ProgressBar>(R.id.progress).visibility = View.INVISIBLE
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
       intent.setClass(this, PrincipalActivity::class.java)
       this.startActivity(intent)
    }
    private fun showToast(context: Context = applicationContext, message: String, duration: Int){
        Toast.makeText(context,message,duration).show()
    }



}