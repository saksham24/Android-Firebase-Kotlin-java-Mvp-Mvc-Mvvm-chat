package nosql.anew.kotlinmvp.views

import nosql.anew.kotlinmvp.models.ChatPojo
import java.util.ArrayList

/**
 * Created by Sam on 27/04/18.
 */
interface IChatView {
    fun updateList(list: ArrayList<ChatPojo>)
    fun clearEditText()
}