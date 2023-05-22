package cat.urv.deim.asm.patinfly.views.scooter


import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import cat.urv.deim.asm.patinfly.adapters.ScooterRecyclerViewAdapter
import cat.urv.deim.asm.patinfly.databinding.ActivityScooterListBinding
import cat.urv.deim.asm.patinfly.models.ScooterRepository
import cat.urv.deim.asm.patinfly.persistence.AppDatabase
import cat.urv.deim.asm.patinfly.persistence.Scooter
import cat.urv.deim.asm.patinfly.persistence.ScooterDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*


class ScootersListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScooterListBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //MVC
        //setContentView(R.layout.activity_main)

        //Binding MVVM o MVP
        binding = ActivityScooterListBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }

    override fun onResume() {
        super.onResume()

        //val scooters:Scooters  = ScooterRepository.activeScooters()

        //Scooters from json file. To access to the file raw/scooters.json:
        val scooters: List<Scooter> = LinkedList()
        val db= AppDatabase.getInstance(this)
        val scooterDao: ScooterDao = db.ScooterDao()

        // Increase performance when the size is static
        binding.scooterRecyclerView.setHasFixedSize(true)


        // Our RecyclerView is using the linear layout manager
        val layoutManager = LinearLayoutManager(applicationContext)
        binding.scooterRecyclerView.setLayoutManager(layoutManager)

        val adapter:ScooterRecyclerViewAdapter = ScooterRecyclerViewAdapter(scooters)
        binding.scooterRecyclerView.adapter = adapter

        databaseUpdateRecyclerViewWithCoroutines(this,scooterDao,adapter)


    }
}

fun databaseUpdateRecyclerViewWithCoroutines(context: Context, scooterDao: ScooterDao, adapter: ScooterRecyclerViewAdapter){
    CoroutineScope(Dispatchers.Main).launch {


        val scootersDeferred: Deferred<List<Scooter>> = ScooterRepository.getAllScooters(context, scooterDao)
        val scooters: List<Scooter> = scootersDeferred.await()
        if (scooters.isEmpty()){
            Log.d(
                "CoroutineScope",
                "databaseUpdateRecyclerViewWithCoroutines: La base de dades està buida"
            )
        }
        else{
            Toast.makeText(context, "The number user is: %s".format(scooters.size), Toast.LENGTH_LONG).show()
            adapter.updateScooters(scooters)
        }
    }
}


