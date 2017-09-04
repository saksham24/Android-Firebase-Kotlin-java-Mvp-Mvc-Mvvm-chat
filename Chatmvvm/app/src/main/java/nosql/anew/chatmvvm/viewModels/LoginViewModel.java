package nosql.anew.chatmvvm.viewModels;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

import nosql.anew.chatmvvm.BR;
import nosql.anew.chatmvvm.interfaces.Observer;
import nosql.anew.chatmvvm.utils.MyUtils;

/**
 * Created by rcmac1 on 30/08/17.
 */

public class LoginViewModel extends BaseObservable{

    private boolean isAuthDone;
    private boolean isAuthInProgress;
    public ArrayList<Observer> observers;

    public LoginViewModel() {
        observers=new ArrayList<>();
    }

    @Bindable
    public boolean isAuthDone() {
        return isAuthDone;
    }

    public void setAuthDone(boolean authDone) {
        isAuthDone = authDone;
        notifyPropertyChanged(BR.authDone);
    }

    @Bindable
    public boolean isAuthInProgress() {
        return isAuthInProgress;
    }

    public void setAuthInProgress(boolean authInProgress) {
        isAuthInProgress = authInProgress;
        notifyPropertyChanged(BR.authInProgress);
    }

    public void firebaseAnonymousAuth() {
        setAuthInProgress(true);
        FirebaseAuth.getInstance().signInAnonymously()
                .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete( Task<AuthResult> task) {
                        setAuthInProgress(false);
                        if (!task.isSuccessful()) {
                            notifyObservers(MyUtils.SHOW_TOAST, MyUtils.MESSAGE_AUTHENTICATION_FAILED);
                        } else {
                            setAuthDone(true);
                        }
                    }
                });
    }

    public void invalidateRoomName(String roomName) {

        if (roomName.trim().isEmpty()){
            notifyObservers(MyUtils.SHOW_TOAST, MyUtils.MESSAGE_INVALIDE_ROOM_NAME);
        } else {
            notifyObservers(MyUtils.OPEN_ACTIVITY, roomName);
        }
    }

    public void addObserver(Observer client) {
        if (!observers.contains(client)) {
            observers.add(client);
        }
    }

    public void removeObserver(Observer clientToRemove) {
        if (observers.contains(clientToRemove)) {
            observers.remove(clientToRemove);
        }
    }

    public void notifyObservers(int eventType, String message) {
        for (int i=0; i< observers.size(); i++) {
            observers.get(i).onObserve(eventType, message);
        }
    }
}
