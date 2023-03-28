package cat.urv.deim.asm.patinfly
data class userInfo(val nom: String = "", val cognom: String = "", val correu: String = "", val telefon: String="", val dni: String = "", val nacionalitat: String ="", val Km: String=""){

}

class UserRepository {
   private val userList = mutableListOf<userInfo>()


    fun addUser(user: userInfo) {
        userList.add(user)
    }


}