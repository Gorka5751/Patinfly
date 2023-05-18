package cat.urv.deim.asm.patinfly.persistence

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query




@Dao
interface ScooterDao {

    @Query("SELECT * FROM scooter")
    fun getAll(): List<Scooter>

    @Insert
    fun insertScooters(vararg scooters: Scooter)

    @Delete
    fun delete(scooter: Scooter)

    @Query ("DELETE FROM scooter")
    fun deleteAll()


}