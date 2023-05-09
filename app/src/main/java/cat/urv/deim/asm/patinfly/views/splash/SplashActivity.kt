package cat.urv.deim.asm.patinfly.views.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cat.urv.deim.asm.patinfly.R
import cat.urv.deim.asm.patinfly.utils.postDelayed
import cat.urv.deim.asm.patinfly.views.login.LoginActivity


//NOM DELS INTEGRANTS DEL GRUP: GORKA ZAMORANO ORÓ I POL CULLERÉ FARRÉ
// GRUP DE ASM --> ASM25

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splashscreen)
        postDelayed(4000){
            val intento1 = Intent(this, LoginActivity::class.java)
            startActivity(intento1)
        }
    }
}