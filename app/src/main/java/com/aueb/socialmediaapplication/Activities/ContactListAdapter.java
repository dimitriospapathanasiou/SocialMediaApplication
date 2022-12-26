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
import com.aueb.socialmediaapplication.Entities.User;
import com.aueb.socialmediaapplication.R;

import java.util.List;

public class ContactListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<User> data;
    Context context;

    public ContactListAdapter(List<User> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item_contact, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int position) {
        final User user = data.get(position);
        ViewHolder customHolder = (ViewHolder) holder;

        TextView username = customHolder.rootView.findViewById(R.id.username);
        TextView last_message = customHolder.rootView.findViewById(R.id.last_message);

        username.setText(user.getUserName());

        last_message.setText(user.getLastMessage());

        username.setTextColor(Color.parseColor("#FFFFFF"));
        last_message.setTextColor(Color.parseColor("#FFFFFF"));
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
