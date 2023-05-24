package cat.urv.deim.asm.patinfly.apiREST

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import cat.urv.deim.asm.patinfly.models.ScooterRepository
import cat.urv.deim.asm.patinfly.models.Scooters
import cat.urv.deim.asm.patinfly.persistence.AppDatabase
import cat.urv.deim.asm.patinfly.persistence.Scooter
import cat.urv.deim.asm.patinfly.persistence.ScooterDao
import cat.urv.deim.asm.patinfly.views.splash.SplashActivity
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException



class OKListener{



    //val db = AppDatabase.getInstance(this)

    //Pasamos el contexto por parametro porque lo necesitaremos para crear la DB ROOM
    fun onResponse(context:Context) {


        val url = "https://patinfly.com/endpoints/scooter"
        val apiKey = "cXwoo4aCs8VKooJyX2ddGQF1WLOjdwNpGvbazLVM2AWAJxVuTy"




        val request = Request.Builder()
            .url(url)
            .addHeader("api-key", apiKey)
            .build()

        val client = OkHttpClient()


        client.newCall(request).enqueue(object : Callback {

            override fun onResponse(call: Call, response: Response) {

                //El response body es el fichero JSON en texto y lo convertimos a objeto
                val responseBody = response.body?.string()
                val scooter = convertJsonToScooter(responseBody)

                //Creamos la base de datos y el ScooterDao con el contexto por parametro
                val db = AppDatabase.getInstance(context)
                val scooterDao: ScooterDao = db.ScooterDao()

                // Aquí introducimos los scooters que hemos cogido del http request dentro
                // de la base de datos ROOM

                for (scooter in scooter.scooters){
                    ScooterRepository.insertArrayScooters(scooterDao,scooter)
                    //println(scooter.name)
                }
            }


            fun convertJsonToScooter(json: String?): Scooters {
                val gson: Gson = Gson()

                var scooters: Scooters
                json.let {
                    scooters = gson.fromJson<Scooters>(json, Scooters::class.java)
                }
                return scooters
            }

            override fun onFailure(call: Call, e: IOException) {
                println("Error al hacer la solicitud HTTP: ${e.message}")
            }




        })

    }
}