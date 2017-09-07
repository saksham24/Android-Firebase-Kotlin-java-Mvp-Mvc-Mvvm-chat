package nosql.anew.chatmvc.controllers;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import nosql.anew.chatmvc.R;
import nosql.anew.chatmvc.utils.MyUtils;

public class LoginController extends AppCompatActivity implements View.OnClickListener {
    private Button mAuth;
    private Button mCreateRoom;
    private Button mEnterExistingRoom;
    private TextView mInfo;
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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_auth:
                firebaseAnonymousAuth();
                break;
            case R.id.button_create_room:
                showRoomDialog();
                break;
            case R.id.button_existing_room:
                showRoomDialog();
                break;
        }
    }

    public void showToast(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    public void authSuccessful() {
        mAuth.setVisibility(View.GONE);
        mCreateRoom.setVisibility(View.VISIBLE);
        mEnterExistingRoom.setVisibility(View.VISIBLE);
        mInfo.setVisibility(View.VISIBLE);
    }

    public void showRoomDialog() {
        mChatRoomDialog=new Dialog(this);
        mChatRoomDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_room,null);
        Button submitRoomName= (Button) view.findViewById(R.id.button_room_submit);
        final EditText editTextRoomName=(EditText) view.findViewById(R.id.edittext_room_name);
        submitRoomName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextRoomName.getText().toString().trim().isEmpty()){
                    showToast("Enter a valid Name");
                } else {
                    startChatActivity(editTextRoomName.getText().toString());
                }
            }
        });

        mChatRoomDialog.setContentView(view);
        mChatRoomDialog.show();

    }

    public void startChatActivity(String roomName) {
        mChatRoomDialog.dismiss();
        mChatRoomDialog=null;

        Intent intent=new Intent(this,ChatController.class);
        intent.putExtra(MyUtils.EXTRA_ROOM_NAME,roomName);
        startActivity(intent);
    }

    public void firebaseAnonymousAuth() {
        mAuth.setText(getString(R.string.text_waiting_for_auth));
        FirebaseAuth.getInstance().signInAnonymously()
                .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                           showToast("Firebase authentication failed, please check your internet connection");
                            mAuth.setText(getString(R.string.authentication_label));
                        } else {
                            authSuccessful();
                        }
                    }
                });
    }

}
