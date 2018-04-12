package nosql.anew.chatmvvm.interfaces;

import java.util.ArrayList;

import nosql.anew.chatmvvm.models.ChatPojo;

/**
 * Created by saksham on 26/6/17.
 */

public interface ModelCallBacks {
    void onModelUpdated(ArrayList<ChatPojo> messages);
}
