package nosql.anew.chatmvp.chat.presenter;

import com.google.firebase.database.DataSnapshot;

/**
 * Created by saksham on 26/6/17.
 */

public interface FirebaseCallBacks {
    void onNewMessage(DataSnapshot dataSnapshot);
}
