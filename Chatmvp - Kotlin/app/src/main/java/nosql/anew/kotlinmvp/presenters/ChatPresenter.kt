package nosql.anew.kotlinmvp.presenters

import com.google.firebase.database.DataSnapshot
import nosql.anew.kotlinmvc.interfaces.FirebaseCallBacks
import nosql.anew.kotlinmvc.interfaces.ModelCallBacks
import nosql.anew.kotlinmvp.models.ChatPojo
import nosql.anew.kotlinmvp.models.MessageModel
import nosql.anew.kotlinmvp.utils.FirebaseManager
import nosql.anew.kotlinmvp.views.IChatView
import java.util.ArrayList

/**
 * Created by Sam on 27/04/18.
 */
class ChatPresenter(private var mIChatView: IChatView?) : FirebaseCallBacks, ModelCallBacks {
    private val mModel: MessageModel

    init {
        this.mModel = MessageModel(this)
    }

    fun sendMessageToFirebase(roomName: String?, message: String) {
        if (!message.trim().equals("")) {
            FirebaseManager.getInstance(roomName!!, this)!!.sendMessageToFirebase(message)
        }
        mIChatView!!.clearEditText()
    }

    fun setListener(roomName : String?) {
        FirebaseManager.getInstance(roomName!!, this)!!.addMessageListeners()
    }

    fun onDestroy(roomName: String?) {
        FirebaseManager.getInstance(roomName!!, this)!!.removeListeners()
        FirebaseManager.getInstance(roomName, this)!!.destroy()
        mIChatView = null
    }

    override fun onNewMessage(dataSnapshot: DataSnapshot?) {
        mModel.addMessages(dataSnapshot!!)
    }

    override fun onModelUpdated(messages: ArrayList<ChatPojo>) {
        if (messages.size > 0) {
            mIChatView!!.updateList(messages)
        }
    }
}
