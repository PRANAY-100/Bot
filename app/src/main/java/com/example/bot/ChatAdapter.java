package com.example.bot;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.transition.Hold;

import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter {
    private ArrayList<ChatsModel> chatsModelArrayList;
    private Context context;

    public ChatAdapter(ArrayList<ChatsModel> chatsModelArrayList,Context context) {
        this.chatsModelArrayList = chatsModelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case 0:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user, parent, false);
                return new UserViewHolder(view);
            case 1:
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.botmsg,parent,false);
                return new BotViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
     ChatsModel chatsModel = chatsModelArrayList.get(position);
     switch (chatsModel.getSender()) {
         case "user" :
             ((UserViewHolder)holder).userTv.setText(chatsModel.getMessage());
             break;

         case "bot" :
             ((BotViewHolder)holder).botMsgTv.setText(chatsModel.getMessage());
             break;
     }
    }
@Override
public int getItemViewType(int postion) {
        switch (chatsModelArrayList.get(postion).getSender()) {
            case "user":
                return 0;
            case "bot":
                return 1;
            default:
                return -1;
        }
}
    @Override
    public int getItemCount() {
        return chatsModelArrayList.size();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        TextView userTv;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            userTv = itemView.findViewById(R.id.User);
        }
    }

          public static class BotViewHolder extends RecyclerView.ViewHolder {
               TextView botMsgTv;
              public BotViewHolder(@NonNull View itemView) {
                  super(itemView);
                  botMsgTv = itemView.findViewById(R.id.idbot);
              }
          }
}
