package cat.urv.deim.asm.patinfly.views.profile

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import cat.urv.deim.asm.patinfly.R
import cat.urv.deim.asm.patinfly.models.UserRepository
import cat.urv.deim.asm.patinfly.views.login.LoginActivity
import cat.urv.deim.asm.patinfly.views.scooter.ScootersListActivity

import cat.urv.deim.asm.patinfly.views.signup.SignupActivity

class ProfileInfoActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_info);




        findViewById<TextView>(R.id.nomProfile).text = UserRepository.userGlobal.nom;
        findViewById<TextView>(R.id.Cognom).text = UserRepository.userGlobal.cognom;
        findViewById<TextView>(R.id.correu).text = UserRepository.userGlobal.correu;
        findViewById<TextView>(R.id.dniText).text = UserRepository.userGlobal.dni;
        findViewById<TextView>(R.id.telefon).text = UserRepository.userGlobal.telefon;
        findViewById<TextView>(R.id.nacio).text = UserRepository.userGlobal.nacionalitat;
        findViewById<TextView>(R.id.kilometres).text = UserRepository.userGlobal.Km;




    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_layout, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        when (item.itemId) {
            R.id.scooters -> {
                navigateToScooters()
                true
            }
            R.id.logout -> {
                navigateToMain()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
        return true
    }
    private fun showToast(context: Context = applicationContext, message: String, duration: Int){
        Toast.makeText(context,message,duration).show()
    }

    fun navigateToScooters() {
        val intent = Intent()
        intent.setClass(this, ScootersListActivity::class.java)
        this.startActivity(intent)
    }
    fun navigateToMain() {
        val intent = Intent()
        intent.setClass(this, LoginActivity::class.java)
        this.startActivity(intent)
    }
}