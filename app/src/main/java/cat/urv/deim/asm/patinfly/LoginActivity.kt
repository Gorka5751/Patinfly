package cat.urv.deim.asm.patinfly

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity


class LoginActivity: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginEmailEditText = this.findViewById<EditText>(R.id.textEmail)
        val loginPasswordEditText = this.findViewById<EditText>(R.id.textPassword)
        val loginSignInButton = this.findViewById<Button>(R.id.LogIn)
        val loginLogInButton = this.findViewById<Button>(R.id.SignIn)

        loginSignInButton.setOnClickListener{
            val email:String = loginEmailEditText.text.toString();
            val password:String = loginPasswordEditText.text.toString();
            this.navigateToProfile()
            Log.d("LoginActivity-Debug",String.format("user: %s password: %s",email,password))

        }
    }

    override fun onStart() {
        super.onStart()
    }


    fun hideProgress(){
        this.findViewById<ProgressBar>(R.id.progress).visibility = View.GONE
    }
     private fun navigateToProfile(){
        val intent: Intent = Intent()
        intent.setClass(this,ProfileActivity::class.java)
        intent.putExtra("key","value")
        this.startActivity(intent)
    }








}