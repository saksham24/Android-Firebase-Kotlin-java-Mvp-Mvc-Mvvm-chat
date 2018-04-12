package nosql.anew.chatmvp.presenters;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import nosql.anew.chatmvp.views.ILoginView;


/**
 * Created by saksham on 20/6/17.
 */

public class LoginPresenter {

    ILoginView mILoginView;

    public LoginPresenter(ILoginView iLoginCallbacks){
        this.mILoginView =iLoginCallbacks;
    }

    public void firebaseAnonymousAuth() {
        mILoginView.changeButtonText();
        FirebaseAuth.getInstance().signInAnonymously()
                .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete( Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            mILoginView.showToast("Firebase authentication failed, please check your internet connection");
                        } else {
                            mILoginView.authSuccessful();
                        }
                    }
                });
    }

    public void invalidateRoomName(String roomName) {

        if (roomName.trim().isEmpty()){
            mILoginView.showToast("Enter a valid Name");
        } else {
            mILoginView.startChatActivity(roomName);
        }
    }

    public void showRoomDialogInActivity(){
        mILoginView.showRoomDialog();
    }
}
