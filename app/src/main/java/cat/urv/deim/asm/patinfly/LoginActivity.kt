package cat.urv.deim.asm.patinfly

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity


class LoginActivity : AppCompatActivity(), LoginView {
    private val presenter = LoginPresenter(this, LoginInteractor())





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.splashscreen)
        postDelayed(4000){
            setContentView(R.layout.activity_main)
            this.hideProgress()
            val loginEmailEditText = this.findViewById<EditText>(R.id.textEmail)
            val loginPasswordEditText = this.findViewById<EditText>(R.id.textPassword)
            val loginSignInButton = this.findViewById<Button>(R.id.SignIn)
            loginSignInButton.setOnClickListener {
                val email: String = loginEmailEditText.text.toString()
                val password: String = loginPasswordEditText.text.toString()
                validateCredentials()
                Log.d("LoginActivity-Debug", String.format("user: %s password: %s", email, password))
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
        val intent = Intent()
        intent.setClass(this, ProfileActivity::class.java)
        intent.putExtra("key","value")
        this.startActivity(intent)
    }


}