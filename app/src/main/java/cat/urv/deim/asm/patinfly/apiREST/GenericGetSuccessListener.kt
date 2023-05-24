package cat.urv.deim.asm.patinfly.apiREST

import android.util.Log
import cat.urv.deim.asm.patinfly.views.login.LoginActivity
import com.android.volley.Response

class GenericGetSuccessListener: Response.Listener<String> {
    override fun onResponse(response: String?) {
        Log.d(LoginActivity::class.java.simpleName,"Response is: ${response?.substring(0, 500)}")
    }
}