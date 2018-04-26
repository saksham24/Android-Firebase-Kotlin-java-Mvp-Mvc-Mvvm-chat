package nosql.anew.kotlinmvp.views

/**
 * Created by Sam on 27/04/18.
 */
interface ILoginView {
    fun showToast(message: String)
    fun authSuccessful()
    fun showRoomDialog()
    fun changeButtonText()
    fun startChatActivity(roomName: String)
}
