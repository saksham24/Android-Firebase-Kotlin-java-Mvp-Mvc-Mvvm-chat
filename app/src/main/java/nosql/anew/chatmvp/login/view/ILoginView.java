package nosql.anew.chatmvp.login.view;

/**
 * Created by saksham on 20/6/17.
 */

public interface ILoginView {
    void showToast(String message);
    void authSuccessful();
    void showRoomDialog();
    void startChatActivity(String roomName);
}
