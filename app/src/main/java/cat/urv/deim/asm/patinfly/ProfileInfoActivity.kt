package cat.urv.deim.asm.patinfly

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class ProfileInfoActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val userRepository = UserRepository();
        val nom = this.findViewById<EditText>(R.id.nomProfile)
        

        setContentView(R.layout.profile_info);
        println(UserRepository.userGlobal.cognom)

    }
}