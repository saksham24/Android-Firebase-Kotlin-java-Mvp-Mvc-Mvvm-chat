package nosql.anew.chatmvvm.views;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;

import nosql.anew.chatmvvm.databinding.ActivityChatBinding;
import nosql.anew.chatmvvm.interfaces.Observer;
import nosql.anew.chatmvvm.utils.MyUtils;
import nosql.anew.chatmvvm.R;
import nosql.anew.chatmvvm.models.ChatPojo;
import nosql.anew.chatmvvm.viewModels.ChatViewModel;

public class ChatActivity extends AppCompatActivity implements Observer<ArrayList<ChatPojo>> {

    private ActivityChatBinding mBinding;
    private ChatViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_chat);
        mViewModel= new ChatViewModel(getIntent().getStringExtra(MyUtils.EXTRA_ROOM_NAME));
        mBinding.setVModel(mViewModel);
        mBinding.setActivity(this);
        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mViewModel.addObserver(this);
        mViewModel.setListener();
    }

    public void sendMessage() {
        mViewModel.sendMessageToFirebase(mBinding.edittextChatMessage.getText().toString());
        mBinding.edittextChatMessage.getText().clear();
    }

    @Override
    public void onObserve(int event, ArrayList<ChatPojo> eventMessage) {
        ChatAdapter chatAdapter=new ChatAdapter(this,eventMessage);
        mBinding.recyclerView.setAdapter(chatAdapter);
        mBinding.recyclerView.scrollToPosition(eventMessage.size()-1);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mViewModel.removeObserver(this);
        mViewModel.onDestory();
    }
}
