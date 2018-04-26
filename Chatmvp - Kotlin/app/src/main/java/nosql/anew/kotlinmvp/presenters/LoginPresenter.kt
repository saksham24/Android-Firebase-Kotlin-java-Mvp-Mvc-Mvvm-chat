package nosql.anew.kotlinmvp.presenters

import com.google.firebase.auth.FirebaseAuth
import nosql.anew.kotlinmvp.views.ILoginView

/**
 * Created by Sam on 27/04/18.
 */
class LoginPresenter(internal var mILoginView: ILoginView) {

    fun firebaseAnonymousAuth() {
        mILoginView.changeButtonText()
        FirebaseAuth.getInstance().signInAnonymously()
                .addOnCompleteListener { task ->
                    if (!task.isSuccessful) {
                        mILoginView.showToast("Firebase authentication failed, please check your internet connection")
                    } else {
                        mILoginView.authSuccessful()
                    }
                }
    }

    fun invalidateRoomName(roomName: String) {

        if (roomName.trim { it <= ' ' }.isEmpty()) {
            mILoginView.showToast("Enter a valid Name")
        } else {
            mILoginView.startChatActivity(roomName)
        }
    }

    fun showRoomDialogInActivity() {
        mILoginView.showRoomDialog()
    }
}
