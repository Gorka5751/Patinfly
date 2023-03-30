package cat.urv.deim.asm.patinfly

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


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