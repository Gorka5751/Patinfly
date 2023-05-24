package cat.urv.deim.asm.patinfly.apiREST

import android.util.Log
import cat.urv.deim.asm.patinfly.views.login.LoginActivity
import com.android.volley.Response
import com.android.volley.VolleyError

class GenericErrorListener: Response.ErrorListener {
    override fun onErrorResponse(error: VolleyError?) {
        Log.e(LoginActivity::class.java.simpleName,"That didn't work!")
    }
}