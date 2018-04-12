package nosql.anew.chatmvvm.interfaces;

/**
 * Created by rcmac1 on 03/09/17.
 */

public interface Observer<T> {
    void onObserve(int event, T eventMessage);
}
