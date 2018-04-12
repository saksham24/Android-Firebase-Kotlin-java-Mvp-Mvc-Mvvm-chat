package nosql.anew.chatmvc.interfaces;

import java.util.ArrayList;

import nosql.anew.chatmvc.model.ChatPojo;

/**
 * Created by saksham on 26/6/17.
 */

public interface ModelCallBacks {
    void onModelUpdated(ArrayList<ChatPojo> messages);
}
