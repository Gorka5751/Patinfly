package cat.urv.deim.asm.patinfly.persistence

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import cat.urv.deim.asm.patinfly.models.Scooters
import java.util.*


@Dao
interface ScooterDao {

    //En aquesta interfície definim les funcions necessaries per interactuar amb la base de dades.

    @Query("SELECT * FROM scooter")
    fun getAll(): List<Scooter>

    @Query("SELECT * FROM scooter WHERE uuid IN (:scooterIds)")
    fun loadById(scooterIds: String):Scooter


    @Insert
    fun insertScooters(vararg scooters: Scooter)

    @Delete
    fun delete(scooter: Scooter)

    @Query ("DELETE FROM scooter")
    fun deleteAll()


}