package cat.urv.deim.asm.patinfly.models

import android.content.Context
import android.database.sqlite.SQLiteConstraintException
import android.util.Log
import android.widget.Toast
import cat.urv.deim.asm.patinfly.repositories.AssetsProvider
import cat.urv.deim.asm.patinfly.adapters.ScooterRecyclerViewAdapter
import cat.urv.deim.asm.patinfly.persistence.ScooterDao
import cat.urv.deim.asm.patinfly.persistence.Scooter
import kotlinx.coroutines.*
import java.lang.Runnable
import java.util.concurrent.Executors




class ScooterRepository {


    companion object{



        fun activeScooterList(context: Context, resource: String): List<Scooter> {
            val scooters: Scooters = ScooterRepository.activeScooters(context, resource)
            return scooters.scooters
        }
        fun getAllScooters(context: Context, scooterDao: ScooterDao) = CoroutineScope(Dispatchers.Default).async {
            return@async scooterDao.getAll()
        }
        fun deleteAllScooters(context: Context, scooterDao: ScooterDao) = CoroutineScope(Dispatchers.Default).async {
            return@async scooterDao.deleteAll()
        }




        fun insertArrayScooters(scooterDao: ScooterDao,scooter: Scooter){
            Executors.newSingleThreadExecutor().execute(Runnable{
                try{
                    scooterDao.insertScooters(scooter)
                } catch (e: SQLiteConstraintException){
                    e.printStackTrace()
                    Log.d(ScooterRepository::class.simpleName,"Unique Valor Error")
                }

            })
        }

        fun activeScooters(context: Context, resource: String): Scooters {
            val scooters: Scooters
            val jsonResource: String? = AssetsProvider.getJsonDataFromRawAsset(context, resource)
            jsonResource.let {
                scooters = ScooterParser.parseFromJson(jsonResource!!)
            }
            return scooters
        }







    }
}