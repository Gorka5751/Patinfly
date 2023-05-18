package cat.urv.deim.asm.patinfly.persistence

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "scooter")
data class Scooter(
    @PrimaryKey val uuid: String,
    @ColumnInfo(name = "nom") val name:String,
    @ColumnInfo(name = "longitud") val longitude:String?,
    @ColumnInfo(name = "latitud") val latitude:String?,
    @ColumnInfo(name = "bateria") val battery_level: String?,
    @ColumnInfo(name = "distancia") val km_use:String?,
    @ColumnInfo(name = "dataManteniment") val date_last_maintenance:String?,
    @ColumnInfo(name = "estat") val state: String?,
    @ColumnInfo(name = "lliure") val on_rent: String?) {

}
