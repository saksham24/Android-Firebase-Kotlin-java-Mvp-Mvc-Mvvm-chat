package nosql.anew.kotlinmvc.interfaces

import nosql.anew.kotlinmvp.models.ChatPojo
import java.util.ArrayList

interface ModelCallBacks {
    fun onModelUpdated(messages: ArrayList<ChatPojo>)
}
