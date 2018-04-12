package nosql.anew.chatmvp.views;

/**
 * Created by saksham on 26/6/17.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

import nosql.anew.chatmvp.utils.MyUtils;
import nosql.anew.chatmvp.R;
import nosql.anew.chatmvp.models.ChatPojo;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.FollowerViewHolder> {


    private ArrayList<ChatPojo> chatList;
    private Context context;

    ChatAdapter(Context context, ArrayList<ChatPojo> chatList) {
        this.chatList =chatList;
        this.context=context;
    }

    @Override
    public FollowerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(context).inflate(R.layout.row_chat_adapter, parent, false);
        return new FollowerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final FollowerViewHolder holder, final int position) {

            if (chatList.get(position).getSenderId().equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {

                holder.layoutLeftMessages.setVisibility(View.GONE);
                holder.layoutRightMessages.setVisibility(View.VISIBLE);

                holder.messagesTextRight.setText(chatList.get(position).getMessage());
                holder.timeMessagesRight.setText(MyUtils.convertTime(chatList.get(position).getTimeStamp()));

            } else {

                holder.layoutLeftMessages.setVisibility(View.VISIBLE);
                holder.layoutRightMessages.setVisibility(View.GONE);

                holder.messagesTextLeft.setText(chatList.get(position).getMessage());
                holder.timeMessagesLeft.setText(MyUtils.convertTime(chatList.get(position).getTimeStamp()));
            }
    }

    @Override
    public int getItemCount() {
        return chatList.size();
    }


    class FollowerViewHolder extends RecyclerView.ViewHolder {

        private TextView messagesTextLeft, timeMessagesLeft, messagesTextRight,timeMessagesRight;
        private LinearLayout layoutLeftMessages, layoutRightMessages;

        FollowerViewHolder(View convertView) {
            super(convertView);

            messagesTextLeft = (TextView) convertView.findViewById(R.id.text_message_left);
            timeMessagesLeft =(TextView) convertView.findViewById(R.id.text_time_messages_left);
            messagesTextRight =(TextView) convertView.findViewById(R.id.text_message_right);
            timeMessagesRight=(TextView) convertView.findViewById(R.id.text_time_message_right);

            layoutLeftMessages =(LinearLayout) convertView.findViewById(R.id.layout_message_left);
            layoutRightMessages =(LinearLayout) convertView.findViewById(R.id.layout_message_right);
        }
    }
}
