package com.aueb.socialmediaapplication.Activities;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aueb.socialmediaapplication.Database.UserDatabase;
import com.aueb.socialmediaapplication.Entities.Message;
import com.aueb.socialmediaapplication.Entities.User;
import com.aueb.socialmediaapplication.R;

import java.util.List;
import androidx.recyclerview.widget.RecyclerView;

public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Message> data;
    Context context;

    public ChatAdapter(List<Message> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_message_received, parent, false);
        return new ChatAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int position) {
        final Message message = data.get(position);
        ChatAdapter.ViewHolder customHolder = (ChatAdapter.ViewHolder) holder;

        TextView txtmsg1 = customHolder.rootView.findViewById(R.id.textMessage);
        TextView txtmsg2 = customHolder.rootView.findViewById(R.id.textMessage2);

        txtmsg1.setText(message.getMessageText());
        txtmsg1.bringToFront();
        txtmsg2.setText(message.getMessageText());
        txtmsg2.bringToFront();
        txtmsg1.setTextColor(Color.parseColor("#FFFFFF"));
        txtmsg2.setTextColor(Color.parseColor("#000000"));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        View rootView;

        public ViewHolder(View itemView) {
            super(itemView);
            rootView = itemView;
        }
    }


}
