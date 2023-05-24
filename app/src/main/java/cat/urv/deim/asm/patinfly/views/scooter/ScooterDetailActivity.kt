package cat.urv.deim.asm.patinfly.views.scooter

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import cat.urv.deim.asm.patinfly.R
import cat.urv.deim.asm.patinfly.apiREST.CustomJsonObjectRequest
import cat.urv.deim.asm.patinfly.apiREST.GenericErrorListener
import cat.urv.deim.asm.patinfly.apiREST.GenericGetSuccessListener
import cat.urv.deim.asm.patinfly.apiREST.OKListener
import cat.urv.deim.asm.patinfly.databinding.ActivityScooterListBinding
import cat.urv.deim.asm.patinfly.persistence.AppDatabase
import cat.urv.deim.asm.patinfly.persistence.Scooter
import cat.urv.deim.asm.patinfly.persistence.ScooterDao
import cat.urv.deim.asm.patinfly.views.login.LoginActivity
import cat.urv.deim.asm.patinfly.views.splash.RefreshScooters
import cat.urv.deim.asm.patinfly.views.splash.SplashActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.coroutines.*
import java.util.*

class ScooterDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScooterListBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scooter_detail_inside)


    }

    @SuppressLint("SetTextI18n")
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
        val botoDesllogar = this.findViewById<Button>(R.id.BotoDesllogar)



        //Definim base de dades i llista de scooters per omplir
        var scooters: List<Scooter> = LinkedList()
        var scooter: Scooter
        val db= AppDatabase.getInstance(this)
        val scooterDao: ScooterDao = db.ScooterDao()

        //Agafem el identificador del patinet que s'ha clicat en la vista i la passem del adapter fins a
        //aquesta activity mitjançant el intent.extra
        var iD = intent.getStringExtra("id") ?: ""
        if(iD!=null){
            println("This is the uuid of the selected scooter: $iD")
        }


        //Hem de realitzar corutines per accedir a la base de dades sino bloqueja la UI.
        CoroutineScope(Dispatchers.IO).launch {
            //val scooters = async { db.ScooterDao().getAll() }.await()

            scooter = scooterDao.loadById(iD)
            println("Este es el id:"+iD)
            println("I el estat es:"+scooter.vacant)

            //Els patinets inactius no mostraran el boto de alquilar

            if(scooter.vacant==true){
                botoLlogar.visibility=View.VISIBLE
                botoDesllogar.visibility=View.GONE
                botoLlogar.setOnClickListener(){
                    makeHTTPRequestVacantTrue()
                    navigateToMain()
                }
            }else{
                botoLlogar.visibility=View.GONE
                botoDesllogar.visibility=View.VISIBLE
                botoDesllogar.setOnClickListener(){
                    makeHTTPRequestVacantFalse()
                    navigateToMain()
                }
            }






            //Omplim tota la info necessaria amb els atributs corresponents
            uuidText.text = "Name: "+scooter.name
            longitudText.text = "Longitude: "+scooter.longitude
            latitudText.text = "Latitude: "+scooter.latitude
            bateriaText.text = "Battery: "+scooter.battery_level+"%"
            metresText.text = "Meters: "+scooter.meters_use+"m"
            //No he vist definit aquest atribut en el fitxer JSON
            incorporacioText.text = "Created: "+scooter.date_create
            mantenimentText.text = "Last mainteinance: "+scooter.date_last_maintenance
            estatText.text = "State: "+scooter.state
            lliureText.text = "On Rent: "+scooter.vacant

        }



        
    }

    fun makeHTTPRequestVacantTrue(){


        // Instantiate the RequestQueue. The queue is unique for all the requests
        val queue = Volley.newRequestQueue(this)


        var url = "https://www.google.com"

        // Generic error response
        val genericErrorListener= GenericErrorListener()
        val genericGetSuccessListener = GenericGetSuccessListener()

        // Request a string response from the provided URL.
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            genericGetSuccessListener,genericErrorListener
        )
            url = "https://patinfly.com/endpoints/rent/start/ea227a94-d480-11ec-91c7-ecf4bbcc40f8"


        val api_key: String = "ACFT8n5PHSqNs1M6divXafzhZbcRO3prKjGUy925"

        //Request with anonymous success json listener and the generic error listener

        val jsonObjectRequest = CustomJsonObjectRequest(
            Request.Method.GET, url, null,
            Response.Listener { response ->
                Log.d(ScooterDetailActivity::class.java.simpleName,"Response is: ${response}")
            },
            genericErrorListener,
            api_key
        )






        // Add the string the request to the RequestQueue
        queue.add(stringRequest)
        // Add the json the request to the RequestQueue
        queue.add(jsonObjectRequest)


    }

    fun makeHTTPRequestVacantFalse(){


        // Instantiate the RequestQueue. The queue is unique for all the requests
        val queue = Volley.newRequestQueue(this)


        var url = "https://www.google.com"

        // Generic error response
        val genericErrorListener= GenericErrorListener()
        val genericGetSuccessListener = GenericGetSuccessListener()

        // Request a string response from the provided URL.
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            genericGetSuccessListener,genericErrorListener
        )
        url = "https://patinfly.com/endpoints/rent/stop/ea227a94-d480-11ec-91c7-ecf4bbcc40f8"


        val api_key: String = "ACFT8n5PHSqNs1M6divXafzhZbcRO3prKjGUy925"

        //Request with anonymous success json listener and the generic error listener

        val jsonObjectRequest = CustomJsonObjectRequest(
            Request.Method.GET, url, null,
            Response.Listener { response ->
                Log.d(ScooterDetailActivity::class.java.simpleName,"Response is: ${response}")
            },
            genericErrorListener,
            api_key
        )






        // Add the string the request to the RequestQueue
        queue.add(stringRequest)
        // Add the json the request to the RequestQueue
        queue.add(jsonObjectRequest)


    }
    fun navigateToMain(){
        val intent = Intent(this, RefreshScooters::class.java)
        startActivity(intent)
    }
}

