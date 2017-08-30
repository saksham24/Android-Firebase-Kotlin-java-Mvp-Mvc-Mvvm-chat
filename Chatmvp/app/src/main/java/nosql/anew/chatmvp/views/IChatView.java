package nosql.anew.chatmvp.views;

import java.util.ArrayList;

import nosql.anew.chatmvp.models.ChatPojo;

/**
 * Created by saksham on 26/6/17.
 */

public interface IChatView {
    void updateList(ArrayList<ChatPojo> list);
    void clearEditText();
}
