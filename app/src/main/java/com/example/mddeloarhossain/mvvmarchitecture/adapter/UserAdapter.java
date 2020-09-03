package com.example.mddeloarhossain.mvvmarchitecture.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mddeloarhossain.mvvmarchitecture.R;
import com.example.mddeloarhossain.mvvmarchitecture.model.User;

/**
 * Created by MD. DELOAR HOSSAIN on 22-Aug-20.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    User[] users;

    public UserAdapter(User[] users) {
        this.users = users;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.user_list, viewGroup,false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {

        holder.name.setText(users[position].getLogin());
        holder.id.setText(String.valueOf(users[position].getId()));
        holder.reposUrl.setText(users[position].getReposUrl());

        Glide.with(holder.avatarImg.getContext()).load(users[position].getAvatarUrl()).into(holder.avatarImg);
    }

    @Override
    public int getItemCount() {
        return users.length;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {

        ImageView avatarImg;
        TextView name, id, reposUrl;

        public UserViewHolder(View itemView) {
            super(itemView);

            avatarImg = itemView.findViewById(R.id.ivAvatarUrl);
            name = itemView.findViewById(R.id.tvName);
            id = itemView.findViewById(R.id.tvId);
            reposUrl = itemView.findViewById(R.id.tvReposUrl);
        }
    }
}
