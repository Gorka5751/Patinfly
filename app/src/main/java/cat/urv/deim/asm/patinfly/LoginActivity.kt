package cat.urv.deim.asm.patinfly

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Message
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.time.Duration


class LoginActivity : AppCompatActivity(), LoginView {
    private val presenter = LoginPresenter(this, LoginInteractor())





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContentView(R.layout.splashscreen)
        postDelayed(3000){
            setContentView(R.layout.activity_main)
            this.hideProgress()
            val loginEmailEditText = this.findViewById<EditText>(R.id.textEmail)
            val loginPasswordEditText = this.findViewById<EditText>(R.id.textPassword)
            val loginSignInButton = this.findViewById<Button>(R.id.LogIn)
            loginSignInButton.setOnClickListener {
                val email: String = loginEmailEditText.text.toString()
                val password: String = loginPasswordEditText.text.toString()
                //validateCredentials()
                if(email.equals(UserRepository.userGlobal.correu) && email!="" && password.equals(UserRepository.userGlobal.contraseña)){

                    showToast(applicationContext,"Has iniciado sesion correctamente",10)

                    val intento3 = Intent(this, PrincipalActivity::class.java)
                    startActivity(intento3)
                }else{
                    showToast(applicationContext,"Datos introducidos incorrectamente",10)
                }
            }
            val botoTutorial=this.findViewById<Button>(R.id.Tutorial1)
            botoTutorial.setOnClickListener {
                val intento1 = Intent(this, TutorialActivity::class.java)
                startActivity(intento1)
            }

            val botoSignIn=this.findViewById<Button>(R.id.SignIn)
            botoSignIn.setOnClickListener {
                val intento2 = Intent(this, SignupActivity::class.java)
                startActivity(intento2)
            }


        }

        //Añadir delay de 2 segundos...









    }

    private fun validateCredentials() {
        val loginEmailEditText = this.findViewById<EditText>(R.id.textEmail)
        val loginPasswordEditText = this.findViewById<EditText>(R.id.textPassword)
        presenter.validateCredentials(  loginEmailEditText.text.toString(),
            loginPasswordEditText.text.toString())

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
        this.findViewById<EditText>(R.id.textEmail).setText("Usuari/email erroni")
    }

    @SuppressLint("SetTextI18n")
    override fun setPasswordError() {
        this.findViewById<EditText>(R.id.textPassword).setText("Login error on Password")
    }

    override fun navigateToProfile() {
       // val intent = Intent()
       // intent.setClass(this, PrincipalActivity::class.java)
       // intent.putExtra("key","value")
       // this.startActivity(intent)
    }
    private fun showToast(context: Context = applicationContext, message: String, duration: Int){
        Toast.makeText(context,message,duration).show()
    }



}