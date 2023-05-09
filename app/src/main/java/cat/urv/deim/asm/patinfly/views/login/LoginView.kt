package cat.urv.deim.asm.patinfly.views.login

interface LoginView {
   fun showProgress()
   fun hideProgress()
   fun setUsernameError()
   fun setPasswordError()
   fun navigateToProfile()
}