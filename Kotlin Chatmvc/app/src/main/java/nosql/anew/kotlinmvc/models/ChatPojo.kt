package nosql.anew.kotlinmvc.models

import com.google.firebase.database.DataSnapshot
import java.util.HashMap

class ChatPojo(dataSnapshot: DataSnapshot) {
    var msgKey: String? = null
    var timeStamp: Long = 0
    var message: String? = null
    var senderId: String? = null

    /**
     * called when the we initialise object
     * Similar to parametric constructor in java
     */
    init {
        val hashMap = dataSnapshot.value as HashMap<String, Any>
        this.msgKey = dataSnapshot.key
        this.message = hashMap["text"].toString()
        this.senderId = hashMap["senderId"].toString()
        this.timeStamp = java.lang.Long.parseLong(hashMap ["time"].toString())
    }

}

