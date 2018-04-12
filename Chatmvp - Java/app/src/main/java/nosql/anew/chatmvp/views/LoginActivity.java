package nosql.anew.chatmvp.views;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import nosql.anew.chatmvp.R;
import nosql.anew.chatmvp.presenters.LoginPresenter;
import nosql.anew.chatmvp.utils.MyUtils;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener,ILoginView {
    private Button mAuth;
    private Button mCreateRoom;
    private Button mEnterExistingRoom;
    private TextView mInfo;
    private LoginPresenter mLoginPresenter;
    private Dialog mChatRoomDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = (Button) findViewById(R.id.button_auth);
        mCreateRoom = (Button) findViewById(R.id.button_create_room);
        mEnterExistingRoom = (Button) findViewById(R.id.button_existing_room);
        mInfo= (TextView) findViewById(R.id.text_info);

        mAuth.setOnClickListener(this);
        mCreateRoom.setOnClickListener(this);
        mEnterExistingRoom.setOnClickListener(this);

        mLoginPresenter=new LoginPresenter(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_auth:
                mLoginPresenter.firebaseAnonymousAuth();
                break;
            case R.id.button_create_room:
                mLoginPresenter.showRoomDialogInActivity();
                break;
            case R.id.button_existing_room:
                mLoginPresenter.showRoomDialogInActivity();
                break;
        }
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void authSuccessful() {
        mAuth.setVisibility(View.GONE);
        mCreateRoom.setVisibility(View.VISIBLE);
        mEnterExistingRoom.setVisibility(View.VISIBLE);
        mInfo.setVisibility(View.VISIBLE);
    }

    @Override
    public void showRoomDialog() {
        mChatRoomDialog=new Dialog(this);
        mChatRoomDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_room,null);
        Button submitRoomName= (Button) view.findViewById(R.id.button_room_submit);
        final EditText editTextRoomName=(EditText) view.findViewById(R.id.edittext_room_name);
        submitRoomName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLoginPresenter.invalidateRoomName(editTextRoomName.getText().toString());
            }
        });

        mChatRoomDialog.setContentView(view);
        mChatRoomDialog.show();

    }

    @Override
    public void changeButtonText() {
        mAuth.setText(getString(R.string.text_waiting_for_auth));
    }

    @Override
    public void startChatActivity(String roomName) {
        mChatRoomDialog.dismiss();
        mChatRoomDialog=null;

        Intent intent=new Intent(this,ChatActivity.class);
        intent.putExtra(MyUtils.EXTRA_ROOM_NAME,roomName);
        startActivity(intent);
    }
}
