package cat.urv.deim.asm.patinfly

interface LoginView {
   fun showProgress()
   fun hideProgress()
   fun setUsernameError()
   fun setPasswordError()
   fun navigateToProfile()
}