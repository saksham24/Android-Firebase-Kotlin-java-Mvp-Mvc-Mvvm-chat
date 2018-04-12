package nosql.anew.chatmvc.model;

import com.google.firebase.database.DataSnapshot;

import java.util.ArrayList;

import nosql.anew.chatmvc.interfaces.ModelCallBacks;

/**
 * Created by saksham on 26/6/17.
 */

public class MessageModel {
    private ArrayList<ChatPojo> mMessages;
    ModelCallBacks mModelCallBacks;

    public MessageModel(ModelCallBacks modelCallBacks){
        this.mModelCallBacks=modelCallBacks;
    }

    public void addMessages(DataSnapshot dataSnapshot){
        if (mMessages==null){
            mMessages= new ArrayList<>();
        }
        ChatPojo chatPojo=new ChatPojo(dataSnapshot);
        mMessages.add(chatPojo);
        mModelCallBacks.onModelUpdated(mMessages);
    }
}
