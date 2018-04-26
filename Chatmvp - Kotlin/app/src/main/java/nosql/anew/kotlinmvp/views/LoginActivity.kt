package nosql.anew.kotlinmvp.views

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import nosql.anew.kotlinmvp.R
import nosql.anew.kotlinmvp.presenters.LoginPresenter
import nosql.anew.kotlinmvp.utils.MyUtils

/**
 * Created by Sam on 27/04/18.
 */
class LoginActivity : AppCompatActivity(), View.OnClickListener, ILoginView {
    private var mAuth: Button? = null
    private var mCreateRoom: Button? = null
    private var mEnterExistingRoom: Button? = null
    private var mInfo: TextView? = null
    private var mLoginPresenter: LoginPresenter? = null
    private var mChatRoomDialog: Dialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mAuth = findViewById(R.id.button_auth) as Button
        mCreateRoom = findViewById(R.id.button_create_room) as Button
        mEnterExistingRoom = findViewById(R.id.button_existing_room) as Button
        mInfo = findViewById(R.id.text_info) as TextView

        mAuth!!.setOnClickListener(this)
        mCreateRoom!!.setOnClickListener(this)
        mEnterExistingRoom!!.setOnClickListener(this)

        mLoginPresenter = LoginPresenter(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.button_auth -> mLoginPresenter!!.firebaseAnonymousAuth()
            R.id.button_create_room -> mLoginPresenter!!.showRoomDialogInActivity()
            R.id.button_existing_room -> mLoginPresenter!!.showRoomDialogInActivity()
        }
    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun authSuccessful() {
        mAuth!!.visibility = View.GONE
        mCreateRoom!!.visibility = View.VISIBLE
        mEnterExistingRoom!!.visibility = View.VISIBLE
        mInfo!!.visibility = View.VISIBLE
    }

    override fun showRoomDialog() {
        mChatRoomDialog = Dialog(this)
        mChatRoomDialog!!.requestWindowFeature(Window.FEATURE_NO_TITLE)
        val view = LayoutInflater.from(this).inflate(R.layout.dialog_room, null)
        val submitRoomName = view.findViewById<View>(R.id.button_room_submit) as Button
        val editTextRoomName = view.findViewById<View>(R.id.edittext_room_name) as EditText
        submitRoomName.setOnClickListener { mLoginPresenter!!.invalidateRoomName(editTextRoomName.text.toString()) }

        mChatRoomDialog!!.setContentView(view)
        mChatRoomDialog!!.show()

    }

    override fun changeButtonText() {
        mAuth!!.text = getString(R.string.text_waiting_for_auth)
    }

    override fun startChatActivity(roomName: String) {
        mChatRoomDialog!!.dismiss()
        mChatRoomDialog = null

        val intent = Intent(this, ChatActivity::class.java)
        intent.putExtra(MyUtils.EXTRA_ROOM_NAME, roomName)
        startActivity(intent)
    }
}
