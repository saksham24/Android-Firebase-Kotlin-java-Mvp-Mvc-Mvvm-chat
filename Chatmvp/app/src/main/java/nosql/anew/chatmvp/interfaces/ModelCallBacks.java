package nosql.anew.chatmvp.interfaces;

import java.util.ArrayList;

import nosql.anew.chatmvp.models.ChatPojo;

/**
 * Created by saksham on 26/6/17.
 */

public interface ModelCallBacks {
    void onModelUpdated(ArrayList<ChatPojo> messages);
}
