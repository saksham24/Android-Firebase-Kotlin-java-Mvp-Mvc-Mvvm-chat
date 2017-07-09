package nosql.anew.chatmvp.chat.presenter;

import java.util.ArrayList;

import nosql.anew.chatmvp.chat.model.ChatPojo;

/**
 * Created by saksham on 26/6/17.
 */

public interface ModelCallBacks {
    void onModelUpdated(ArrayList<ChatPojo> messages);
}
