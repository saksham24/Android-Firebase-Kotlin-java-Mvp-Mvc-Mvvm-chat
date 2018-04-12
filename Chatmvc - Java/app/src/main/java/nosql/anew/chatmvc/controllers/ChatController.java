package nosql.anew.chatmvc.controllers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;

import java.util.ArrayList;

import nosql.anew.chatmvc.R;
import nosql.anew.chatmvc.interfaces.FirebaseCallBacks;
import nosql.anew.chatmvc.interfaces.ModelCallBacks;
import nosql.anew.chatmvc.managers.FirebaseManager;
import nosql.anew.chatmvc.model.ChatPojo;
import nosql.anew.chatmvc.model.MessageModel;
import nosql.anew.chatmvc.utils.MyUtils;
import nosql.anew.chatmvc.views.ChatAdapter;


public class ChatController extends AppCompatActivity implements View.OnClickListener,FirebaseCallBacks,ModelCallBacks {

    private EditText mEdittextChat;
    private RecyclerView mRecyclerView;
    private String mRoomName;
    private MessageModel mModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        mRoomName=getIntent().getStringExtra(MyUtils.EXTRA_ROOM_NAME);
        mModel=new MessageModel(this);
        setListener(mRoomName);

        mEdittextChat=(EditText) findViewById(R.id.edittext_chat_message);
        mRecyclerView=(RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        findViewById(R.id.button_send_message).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_send_message:
                sendMessageToFirebase(mRoomName,mEdittextChat.getText().toString());
                break;
        }
    }

    public void updateList(ArrayList<ChatPojo> list) {
        ChatAdapter chatAdapter=new ChatAdapter(this,list);
        mRecyclerView.setAdapter(chatAdapter);
        mRecyclerView.scrollToPosition(list.size()-1);
    }

    @Override
    public void onNewMessage(DataSnapshot dataSnapshot) {
        mModel.addMessages(dataSnapshot);
    }

    @Override
    public void onModelUpdated(ArrayList<ChatPojo> messages) {
        if (messages.size()>0) {
            updateList(messages);
        }
    }

    public void sendMessageToFirebase(String roomName, String message) {
        if (!message.trim().equals("")){
            FirebaseManager.getInstance(roomName,this).sendMessageToFirebase(message);
        }
        mEdittextChat.setText("");
    }

    public void setListener(String roomName) {
        FirebaseManager.getInstance(roomName,this).addMessageListeners();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        FirebaseManager.getInstance(mRoomName,this).removeListeners();
        FirebaseManager.getInstance(mRoomName,this).destroy();
    }
}
