package nosql.anew.chatmvvm.views;

/**
 * Created by saksham on 26/6/17.
 */

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import nosql.anew.chatmvvm.BR;
import nosql.anew.chatmvvm.R;
import nosql.anew.chatmvvm.databinding.RowChatAdapterBinding;
import nosql.anew.chatmvvm.models.ChatPojo;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.BindingHolder> {


    private ArrayList<ChatPojo> chatList;
    private Context mContext;

    public ChatAdapter(Context context, ArrayList<ChatPojo> chatList) {
        this.chatList =chatList;
        this.mContext =context;
    }

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.row_chat_adapter, parent, false);
        RowChatAdapterBinding binding=DataBindingUtil.bind(view);
        return new BindingHolder(binding);
    }

    @Override
    public void onBindViewHolder(final BindingHolder holder, final int position) {
        holder.getBinding().setVariable(BR.chatMessage, chatList.get(position));
        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return chatList.size();
    }


    class BindingHolder extends RecyclerView.ViewHolder {

        private RowChatAdapterBinding binding;

        BindingHolder(RowChatAdapterBinding binding) {
            super(binding.getRoot());
            setBinding(binding);
        }

        public void setBinding(RowChatAdapterBinding binding) {
            this.binding = binding;
        }

        public RowChatAdapterBinding getBinding() {
            return binding;
        }
    }
}
