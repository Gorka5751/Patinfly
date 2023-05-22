package cat.urv.deim.asm.patinfly.views.scooter



import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import cat.urv.deim.asm.patinfly.adapters.ScooterRecyclerViewAdapter
import cat.urv.deim.asm.patinfly.databinding.ActivityScooterListBinding
import cat.urv.deim.asm.patinfly.models.ScooterRepository.Companion.databaseUpdateRecyclerViewWithCoroutines
import cat.urv.deim.asm.patinfly.persistence.AppDatabase
import cat.urv.deim.asm.patinfly.persistence.Scooter
import cat.urv.deim.asm.patinfly.persistence.ScooterDao

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


        //Definim base de dades i llista de scooters per omplir
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

        //Fem servir aquesta funció de corutina per fer un GET de tots els scooters i actualitzar
        //la llista de scooters definida previament.
        databaseUpdateRecyclerViewWithCoroutines(this,scooterDao,adapter)


    }
}




