package cat.urv.deim.asm.patinfly.views.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cat.urv.deim.asm.patinfly.R

import cat.urv.deim.asm.patinfly.base.AppConfig.Companion.DEFAULT_SCOOTER_RAW_JSON_FILE

import cat.urv.deim.asm.patinfly.models.ScooterRepository
import cat.urv.deim.asm.patinfly.persistence.AppDatabase
import cat.urv.deim.asm.patinfly.persistence.ScooterDao
import cat.urv.deim.asm.patinfly.persistence.Scooter
import cat.urv.deim.asm.patinfly.utils.postDelayed
import cat.urv.deim.asm.patinfly.views.login.LoginActivity




//NOM DELS INTEGRANTS DEL GRUP: GORKA ZAMORANO ORÓ I POL CULLERÉ FARRÉ
// GRUP DE ASM --> ASM25

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splashscreen)
        val scooters : List<Scooter> = ScooterRepository.activeScooterList(this,DEFAULT_SCOOTER_RAW_JSON_FILE)
        val db = AppDatabase.getInstance(this)
        val scooterDao: ScooterDao = db.ScooterDao()
        //Insertem els scooters del JSON a la base de dades just al obrir la app.
        for (scooter in scooters){
            ScooterRepository.insertArrayScooters(scooterDao,scooter)
        }


        postDelayed(5000){
            val intento1 = Intent(this, LoginActivity::class.java)
            startActivity(intento1)
        }
    }


}
