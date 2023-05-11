package cat.urv.deim.asm.patinfly.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import cat.urv.deim.asm.patinfly.R
import cat.urv.deim.asm.patinfly.models.Scooters

class ScooterRecyclerViewAdapter(private val scooters: Scooters) :
    RecyclerView.Adapter<ScooterRecyclerViewAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView
        val LongitudView: TextView
        val LatitudView: TextView
        val BatteryView: TextView
        val KilometerView: TextView
        val root: View

        init {
            // Define click listener for the ViewHolder's View.
            textView = view.findViewById(R.id.textView)
            LongitudView = view.findViewById(R.id.LongitudView)
            LatitudView = view.findViewById(R.id.LatitudView)
            BatteryView= view.findViewById(R.id.BatteryView)
            KilometerView = view.findViewById(R.id.KilometersView)
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
        viewHolder.textView.text = "Id: "+ scooters.scooters.get(position).uuid
        viewHolder.LongitudView.text = scooters.scooters.get(position).longitude.toString()
        viewHolder.LatitudView.text = scooters.scooters.get(position).latitude.toString()
        viewHolder.BatteryView.text = "Battery: " + scooters.scooters.get(position).battery_level.toString() + "%"
        viewHolder.KilometerView.text = "Kilometers: " + scooters.scooters.get(position).km_use.toString() + "Km"

        viewHolder.root.setOnClickListener {
            Toast.makeText(viewHolder.root.context,
                "Row selected %d".format(position),
                Toast.LENGTH_LONG).show()
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = scooters.scooters.size

}