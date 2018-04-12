package nosql.anew.chatmvp.views;

/**
 * Created by saksham on 20/6/17.
 */

public interface ILoginView {
    void showToast(String message);
    void authSuccessful();
    void showRoomDialog();
    void changeButtonText();
    void startChatActivity(String roomName);
}
