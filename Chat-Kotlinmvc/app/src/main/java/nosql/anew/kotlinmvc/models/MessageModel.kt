package nosql.anew.kotlinmvc.models

import com.google.firebase.database.DataSnapshot
import nosql.anew.kotlinmvc.interfaces.ModelCallBacks
import java.util.ArrayList

/**
 * Created by Sam on 11/04/18.
 */
class MessageModel(internal var mModelCallBacks: ModelCallBacks) {
    private var mMessages: ArrayList<ChatPojo>? = null

    fun addMessages(dataSnapshot: DataSnapshot) {
        if (mMessages == null) {
            mMessages = ArrayList()
        }

        val chatPojo = ChatPojo(dataSnapshot)
        mMessages!!.add(chatPojo)
        mModelCallBacks.onModelUpdated(mMessages!!)
    }
}