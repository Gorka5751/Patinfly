package cat.urv.deim.asm.patinfly.views.scooter



import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import cat.urv.deim.asm.patinfly.R
import cat.urv.deim.asm.patinfly.adapters.ScooterRecyclerViewAdapter
import cat.urv.deim.asm.patinfly.apiREST.OKListener
import cat.urv.deim.asm.patinfly.databinding.ActivityScooterListBinding
import cat.urv.deim.asm.patinfly.models.ScooterRepository
import cat.urv.deim.asm.patinfly.models.ScooterRepository.Companion.databaseUpdateRecyclerViewWithCoroutines
import cat.urv.deim.asm.patinfly.persistence.AppDatabase
import cat.urv.deim.asm.patinfly.persistence.Scooter
import cat.urv.deim.asm.patinfly.persistence.ScooterDao
import cat.urv.deim.asm.patinfly.views.login.LoginActivity
import cat.urv.deim.asm.patinfly.views.profile.ProfileInfoActivity

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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_layout, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        when (item.itemId) {
            R.id.profile -> {
                navigateToProfile()

            }
            R.id.logout -> {
                navigateToMain()

            }
            else -> super.onOptionsItemSelected(item)
        }
        return true
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



    fun navigateToProfile() {
        val intent = Intent()
        intent.setClass(this, ProfileInfoActivity::class.java)
        this.startActivity(intent)
    }

    fun navigateToMain() {
        val intent = Intent()
        intent.setClass(this, LoginActivity::class.java)
        this.startActivity(intent)
    }
}





