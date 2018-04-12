package nosql.anew.chatkotlinmvc.interfaces

import nosql.anew.chatkotlinmvc.models.ChatPojo
import java.util.ArrayList

interface ModelCallBacks {
    fun onModelUpdated(messages: ArrayList<ChatPojo>)
}
