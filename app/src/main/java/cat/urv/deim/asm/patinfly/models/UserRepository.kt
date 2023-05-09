package cat.urv.deim.asm.patinfly.models
data class User(val nom: String = "", val cognom: String = "", val correu: String = "", val telefon: String="", val dni: String = "", val nacionalitat: String ="", val Km: String="",val contraseña: String=""){

}

class UserRepository {


companion object{
    var userGlobal: User = User("","","","","","","")

    fun createUser( nom: String = "",  cognom: String = "",  correu: String = "",  telefon: String="",  dni: String = "",
                    nacionalitat: String ="",  km: String="", contrasenya: String=""){
        createUser(User(nom,cognom,correu,telefon,dni,nacionalitat,km,contrasenya))
    }

    fun createUser(user: User){
        userGlobal = user

    }
}




    fun getUser(user: User): User {
      return user
    }



}