package com.nesquena.recyclerviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class UserRecyclerViewAdapter extends RecyclerView.Adapter<UserRecyclerViewAdapter.ViewHolder> {
    ArrayList<User> users;

    public UserRecyclerViewAdapter(ArrayList<User> users) {
        this.users = users;
    }

    // Create new items (invoked by the layout manager)
    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public UserRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflate the layout
        View itemView = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_user, parent, false);
        // Return a new holder instance
        return new UserRecyclerViewAdapter.ViewHolder(parent.getContext(), itemView);
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(UserRecyclerViewAdapter.ViewHolder holder, int position) {
        // Get the data model based on position
        final User user = users.get(position);
        // Set item views based on the data model
        holder.tvName.setText(user.name);
        holder.tvHometown.setText(user.hometown);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), user.name, Toast.LENGTH_LONG).show();
            }
        });
    }

    // Return the total count of users
    @Override
    public int getItemCount() {
        return users.size();
    }

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName;
        public TextView tvHometown;
        private Context context;

        public ViewHolder(Context context, View itemView) {
            super(itemView);
            this.context = context;
            this.tvName = (TextView) itemView.findViewById(R.id.tvName);
            this.tvHometown = (TextView) itemView.findViewById(R.id.tvHometown);
        }
    }
}
