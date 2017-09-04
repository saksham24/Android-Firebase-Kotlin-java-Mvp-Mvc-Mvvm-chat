package nosql.anew.chatmvvm.models;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Observable;

import nosql.anew.chatmvvm.utils.MyUtils;

/**
 * Created by saksham on 26/6/17.
 */

public class ChatPojo  extends BaseObservable {

    private String msgKey;
    private String timeStamp;
    private String message;
    private boolean isMine;


    public ChatPojo(DataSnapshot dataSnapshot){
        HashMap<String, Object> object = (HashMap<String, Object>) dataSnapshot.getValue();
        this.msgKey=dataSnapshot.getKey();
        this.message=object.get("text").toString();
        if (object.get("senderId").toString().equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
            isMine = true;
        }
        this.timeStamp= MyUtils.convertTime(Long.parseLong(object.get("time").toString()));
    }

    @Bindable
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMsgKey() {
        return msgKey;
    }

    public void setMsgKey(String msgKey) {
        this.msgKey = msgKey;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public boolean isMine() {
        return isMine;
    }

    public void setMine(boolean mine) {
        isMine = mine;
    }
}
