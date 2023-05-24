package cat.urv.deim.asm.patinfly.views.splash

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import cat.urv.deim.asm.patinfly.R

import cat.urv.deim.asm.patinfly.base.AppConfig.Companion.DEFAULT_SCOOTER_RAW_JSON_FILE

import cat.urv.deim.asm.patinfly.models.ScooterRepository
import cat.urv.deim.asm.patinfly.persistence.AppDatabase
import cat.urv.deim.asm.patinfly.persistence.ScooterDao
import cat.urv.deim.asm.patinfly.persistence.Scooter
import cat.urv.deim.asm.patinfly.utils.postDelayed
import cat.urv.deim.asm.patinfly.views.login.LoginActivity
import cat.urv.deim.asm.patinfly.apiREST.OKListener
import cat.urv.deim.asm.patinfly.views.scooter.ScootersListActivity


class RefreshScooters : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splashscreen)

        val db = AppDatabase.getInstance(this)
        val scooterDao: ScooterDao = db.ScooterDao()
        ScooterRepository.deleteAllScooters(this,scooterDao)
        OKListener().onResponse(this)



        postDelayed(2000){
            val intent = Intent(this, ScootersListActivity::class.java)
            startActivity(intent)
        }
    }


}


