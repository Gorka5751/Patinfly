package cat.urv.deim.asm.patinfly.views.scooter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import cat.urv.deim.asm.patinfly.R
import cat.urv.deim.asm.patinfly.databinding.ActivityScooterListBinding
import cat.urv.deim.asm.patinfly.persistence.AppDatabase
import cat.urv.deim.asm.patinfly.persistence.Scooter
import cat.urv.deim.asm.patinfly.persistence.ScooterDao
import kotlinx.coroutines.*
import java.util.*

class ScooterDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScooterListBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scooter_detail_inside)

    }

    override fun onResume() {
        super.onResume()
        //Fem referencia als widgets del layout
        val uuidText = this.findViewById<TextView>(R.id.Identificador)
        val longitudText = this.findViewById<TextView>(R.id.Longitud)
        val latitudText = this.findViewById<TextView>(R.id.Latitud)
        val bateriaText = this.findViewById<TextView>(R.id.Bateria)
        val metresText = this.findViewById<TextView>(R.id.MetresRecorreguts)
        val incorporacioText = this.findViewById<TextView>(R.id.DataIncorporacio)
        val mantenimentText = this.findViewById<TextView>(R.id.Manteniment)
        val estatText = this.findViewById<TextView>(R.id.Estat)
        val lliureText = this.findViewById<TextView>(R.id.Lliure)
        val botoLlogar = this.findViewById<Button>(R.id.BotoLlogar)



        //Definim base de dades i llista de scooters per omplir
        var scooters: List<Scooter> = LinkedList()
        val db= AppDatabase.getInstance(this)
        val scooterDao: ScooterDao = db.ScooterDao()

        //Agafem la posició que s'ha clicat a la vista i la passem del adapter fins a
        //aquesta activity mitjançant el intent.extra
        val position = intent.getIntExtra("position",0)
        if(position!=null){
            println("Aquesta es la posicio"+position)
        }


        //Hem de realitzar corutines per accedir a la base de dades sino bloqueja la UI.
        CoroutineScope(Dispatchers.IO).launch {
            val scooters = async { db.ScooterDao().getAll() }.await()

            //Els patinets inactius no mostraran el boto de alquilar
            if(scooters.get(position).state=="INACTIVE"){
                botoLlogar.visibility=View.GONE
            }


            //Omplim tota la info necessaria amb els atributs corresponents
            uuidText.text = "Name: "+scooters.get(position).name
            longitudText.text = "Longitude: "+scooters.get(position).longitude
            latitudText.text = "Latitude: "+scooters.get(position).latitude
            bateriaText.text = "Battery: "+scooters.get(position).battery_level
            metresText.text = "Meters: "+scooters.get(position).km_use
            //No he vist definit aquest atribut en el fitxer JSON
            incorporacioText.text = ""
            mantenimentText.text = "Last mainteinance: "+scooters.get(position).date_last_maintenance
            estatText.text = "State: "+scooters.get(position).state
            lliureText.text = "On Rent: "+scooters.get(position).on_rent

        }




    }
}

