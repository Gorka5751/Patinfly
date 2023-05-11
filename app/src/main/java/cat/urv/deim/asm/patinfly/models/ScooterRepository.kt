package cat.urv.deim.asm.patinfly.models

import android.content.Context
import cat.urv.deim.asm.patinfly.base.AppConfig
import cat.urv.deim.asm.patinfly.repositories.AssetsProvider

data class Scooter(val uuid: String = "", val longitude: Double = 0.0, val latitude : Double = 0.0,
                   val battery_level: Int=0, val km_use: Int = 0, val date_last_maintenance: String ="", val manteniment: String=""
                   ,val state: String="", val on_rent:Boolean=false) {
}

class ScooterRepository {


    companion object{
        var ScooterGlobal: Scooter = Scooter("",0.0,0.0, 0,
            0,  "", "","",false)


        fun activeScooterList(context: Context, resource: String): List<Scooter> {
            val scooters: Scooters = ScooterRepository.activeScooters(context, resource)
            return scooters.scooters
        }

        fun activeScooters(context: Context, resource: String): Scooters {
            val scooters: Scooters
            val jsonResource: String? = AssetsProvider.getJsonDataFromRawAsset(context, resource)
            jsonResource.let {
                scooters = ScooterParser.parseFromJson(jsonResource!!)
            }
            return scooters
        }

        fun activeScooters(context: Context): Scooters {
            val resource: String = AppConfig.DEFAULT_SCOOTER_RAW_JSON_FILE
            return ScooterRepository.activeScooters(context, resource)
        }

        fun activeScooters(): Scooters {
            val scooters: Scooters = Scooters()
            val uuidList: Array<String> = AppConfig.DEFAULT_SCOOTERS_ID_ARRAY
            var scooter: Scooter
            uuidList.forEach {
                scooter = Scooter(uuid = it)
                scooters.scooters.add(scooter)
            }

            return scooters
        }
    }
}