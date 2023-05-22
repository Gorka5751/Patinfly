package cat.urv.deim.asm.patinfly.adapters

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cat.urv.deim.asm.patinfly.R
import cat.urv.deim.asm.patinfly.persistence.Scooter
import cat.urv.deim.asm.patinfly.views.scooter.ScooterDetailActivity



class ScooterRecyclerViewAdapter(private var scooters: List<Scooter>) :
    RecyclerView.Adapter<ScooterRecyclerViewAdapter.ViewHolder>() {



    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val textView: TextView  //nom del patinet
        val BatteryView: TextView


        val root: View

        init {
            // Define click listener for the ViewHolder's View.
            textView = view.findViewById(R.id.textView)
            BatteryView= view.findViewById(R.id.BatteryView)

            root = view

        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.activity_scooter_detail, viewGroup, false)

        return ViewHolder(view)
    }


    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {


        // Get element from your dataset at this position and replace the
        // contents of the view with that element

        //Nomes voldrem mostrar la informació dels patinets amb estat ACTIU
        if(scooters.get(position).state == "ACTIVE"){
            viewHolder.textView.text = scooters.get(position).name
            viewHolder.BatteryView.text = "Battery: " + scooters.get(position).battery_level.toString() + "%"
        }else{
            viewHolder.textView.text = "NO DISPONIBLE"
            viewHolder.BatteryView.text=""
        }

        viewHolder.root.setOnClickListener {

            //Passarem per paràmetre intent el valor de la posició per a que després
            //puguem saber en quina fila fa click el usuari i poder mostrar la informació
            //corresponent. En el ScooterDetailActivity es mostra la implementació per l'altra banda.
            val intent = Intent(viewHolder.root.context, ScooterDetailActivity::class.java)
            intent.putExtra("position",position)
            viewHolder.root.context.startActivity(intent)

        }

    }


    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = scooters.size

    //Aquesta funció la farem servir per fer un GET dels patinets en la corutina i poder-ho actualitzar.
    fun updateScooters(scooters: List<Scooter>) {
        this.scooters = scooters
        this.notifyDataSetChanged()
    }




}


