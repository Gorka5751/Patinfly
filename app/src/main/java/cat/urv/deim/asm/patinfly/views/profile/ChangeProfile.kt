package cat.urv.deim.asm.patinfly.views.profile

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import cat.urv.deim.asm.patinfly.R
import cat.urv.deim.asm.patinfly.models.UserRepository
import cat.urv.deim.asm.patinfly.views.scooter.ScootersListActivity

class ChangeProfile: AppCompatActivity() {



        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.profile_info_canviar);

            findViewById<TextView>(R.id.nomProfile).text = UserRepository.userGlobal.nom;
            findViewById<TextView>(R.id.Cognom).text = UserRepository.userGlobal.cognom;
            findViewById<TextView>(R.id.correu).text = UserRepository.userGlobal.correu;
            findViewById<TextView>(R.id.dniText).text = UserRepository.userGlobal.dni;
            findViewById<TextView>(R.id.telefon).text = UserRepository.userGlobal.telefon;
            findViewById<TextView>(R.id.nacio).text = UserRepository.userGlobal.nacionalitat;
            findViewById<TextView>(R.id.kilometres).text = UserRepository.userGlobal.Km;




            val botoDone = findViewById<Button>(R.id.done)

            botoDone.setOnClickListener() {



               val nom= findViewById<EditText>(R.id.nomProfile).text.toString()
               val cognom = findViewById<EditText>(R.id.Cognom).text.toString()
               val correu = findViewById<EditText>(R.id.correu).text.toString()
               val dni = findViewById<EditText>(R.id.dniText).text.toString()
               val telef= findViewById<EditText>(R.id.telefon).text.toString()
               val nacionalitat = findViewById<EditText>(R.id.nacio).text.toString()
               val kilometers= findViewById<EditText>(R.id.kilometres).text.toString()

                UserRepository.modifyUser(nom,cognom,correu,dni,telef,nacionalitat,kilometers)

                val intent = Intent()
                intent.setClass(this, ProfileInfoActivity::class.java)
                this.startActivity(intent)
            }

        }



}