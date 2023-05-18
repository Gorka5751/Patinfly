package cat.urv.deim.asm.patinfly.developing


import cat.urv.deim.asm.patinfly.persistence.ScooterDao

import java.util.concurrent.Executors

class DevUtils {
    companion object{
        fun deleteFakeData(scooterDao: ScooterDao){
            Executors.newSingleThreadExecutor().execute(Runnable {
                scooterDao.deleteAll()

            })
        }






    }

}