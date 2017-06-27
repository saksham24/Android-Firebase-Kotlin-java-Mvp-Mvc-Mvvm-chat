package nosql.anew.chatmvp.chat.view;

import java.util.ArrayList;

import nosql.anew.chatmvp.chat.model.ChatPojo;

/**
 * Created by saksham on 26/6/17.
 */

public interface IChatView {
    void updateList(ArrayList<ChatPojo> list);
    void clearEditText();
}
