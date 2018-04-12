package nosql.anew.kotlinmvc.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import nosql.anew.kotlinmvc.R
import nosql.anew.kotlinmvc.models.ChatPojo
import nosql.anew.kotlinmvc.utils.MyUtils
import java.util.ArrayList

/**
 * Created by Sam on 12/04/18.
 */
class ChatAdapter(private val context: Context, private val chatList: ArrayList<ChatPojo>) : RecyclerView.Adapter<ChatAdapter.FollowerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowerViewHolder {

        val itemView = LayoutInflater.from(context).inflate(R.layout.row_chat_adapter, parent, false)
        return FollowerViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FollowerViewHolder, position: Int) {

        if (chatList[position].senderId.equals(FirebaseAuth.getInstance().currentUser!!.uid)) {

            holder.layoutLeftMessages.visibility = View.GONE
            holder.layoutRightMessages.visibility = View.VISIBLE

            holder.messagesTextRight.text = chatList[position].message
            holder.timeMessagesRight.text = MyUtils.convertTime(chatList[position].timeStamp)

        } else {

            holder.layoutLeftMessages.visibility = View.VISIBLE
            holder.layoutRightMessages.visibility = View.GONE

            holder.messagesTextLeft.text = chatList[position].message
            holder.timeMessagesLeft.text = MyUtils.convertTime(chatList[position].timeStamp)
        }
    }

    override fun getItemCount(): Int {
        return chatList.size
    }


    inner class FollowerViewHolder(convertView: View) : RecyclerView.ViewHolder(convertView) {

        val messagesTextLeft: TextView
        val timeMessagesLeft: TextView
        val messagesTextRight: TextView
        val timeMessagesRight: TextView
        val layoutLeftMessages: LinearLayout
        val layoutRightMessages: LinearLayout

        init {
            messagesTextLeft = convertView.findViewById<View>(R.id.text_message_left) as TextView
            timeMessagesLeft = convertView.findViewById<View>(R.id.text_time_messages_left) as TextView
            messagesTextRight = convertView.findViewById<View>(R.id.text_message_right) as TextView
            timeMessagesRight = convertView.findViewById<View>(R.id.text_time_message_right) as TextView

            layoutLeftMessages = convertView.findViewById<View>(R.id.layout_message_left) as LinearLayout
            layoutRightMessages = convertView.findViewById<View>(R.id.layout_message_right) as LinearLayout
        }
    }
}
