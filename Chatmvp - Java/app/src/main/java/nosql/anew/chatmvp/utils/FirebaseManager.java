package nosql.anew.chatmvp.utils;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

import nosql.anew.chatmvp.interfaces.FirebaseCallBacks;

/**
 * Created by saksham on 26/6/17.
 */

public class FirebaseManager implements ChildEventListener{
    private volatile static FirebaseManager sFirebaseManager;
    private DatabaseReference mMessageReference;
    private FirebaseCallBacks mCallbacks;

    public static synchronized FirebaseManager getInstance(String roomName, FirebaseCallBacks callBacks) {
        if(sFirebaseManager == null) {
            synchronized (FirebaseManager.class) {
                sFirebaseManager = new FirebaseManager(roomName,callBacks);
            }
        }
        return sFirebaseManager;
    }

    private FirebaseManager(String roomName, FirebaseCallBacks callBacks){
        mMessageReference = FirebaseDatabase.getInstance().getReference().child(roomName);
        this.mCallbacks =callBacks;
    }

    public void addMessageListeners(){
        mMessageReference.addChildEventListener(this);
    }

    public void removeListeners(){
        mMessageReference.removeEventListener(this);
    }

    @Override
    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
        mCallbacks.onNewMessage(dataSnapshot);
    }

    @Override
    public void onChildChanged(DataSnapshot dataSnapshot, String s) {

    }

    @Override
    public void onChildRemoved(DataSnapshot dataSnapshot) {

    }

    @Override
    public void onChildMoved(DataSnapshot dataSnapshot, String s) {

    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }

    public void sendMessageToFirebase(String message) {
        Map<String,Object> map=new HashMap<>();
        map.put("text",message);
        map.put("time",System.currentTimeMillis());
        map.put("senderId", FirebaseAuth.getInstance().getCurrentUser().getUid());

        String keyToPush= mMessageReference.push().getKey();
        mMessageReference.child(keyToPush).setValue(map);
    }

    public void destroy() {
        sFirebaseManager=null;
        mCallbacks =null;
    }
}
