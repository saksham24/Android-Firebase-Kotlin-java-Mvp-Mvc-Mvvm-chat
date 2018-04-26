package nosql.anew.kotlinmvp.views

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.EditText
import nosql.anew.kotlinmvp.R
import nosql.anew.kotlinmvp.models.ChatPojo
import nosql.anew.kotlinmvp.presenters.ChatPresenter
import nosql.anew.kotlinmvp.utils.MyUtils

/**
 * Created by Sam on 27/04/18.
 */
class ChatActivity : AppCompatActivity(), View.OnClickListener, IChatView {

    private var mEdittextChat: EditText? = null
    private var mChatPresenter: ChatPresenter? = null
    private var mRecyclerView: RecyclerView? = null
    private var mRoomName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        mRoomName = getIntent().getStringExtra(MyUtils.EXTRA_ROOM_NAME)
        mChatPresenter = ChatPresenter(this)
        mChatPresenter!!.setListener(mRoomName)

        mEdittextChat = findViewById(R.id.edittext_chat_message) as EditText
        mRecyclerView = findViewById(R.id.recycler_view) as RecyclerView
        mRecyclerView!!.layoutManager = LinearLayoutManager(this)


        findViewById(R.id.button_send_message).setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.button_send_message -> mChatPresenter!!.sendMessageToFirebase(mRoomName, mEdittextChat!!.text.toString())
        }
    }

    override fun updateList(list: ArrayList<ChatPojo>) {
        val chatAdapter = ChatAdapter(this, list)
        mRecyclerView!!.adapter = chatAdapter
        mRecyclerView!!.scrollToPosition(list.size - 1)
    }

    override fun clearEditText() {
        mEdittextChat!!.setText("")
    }

    protected override fun onDestroy() {
        super.onDestroy()
        mChatPresenter!!.onDestroy(mRoomName)
    }
}
