package com.tumblr.b1moz.caderninho003.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tumblr.b1moz.caderninho003.R;
import com.tumblr.b1moz.caderninho003.domain.Costumer;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class MyClientListRecyclerViewAdapter extends RecyclerView.Adapter<MyClientListRecyclerViewAdapter.ViewHolder> {

    List<Costumer> mList;

    public MyClientListRecyclerViewAdapter(List<Costumer> mList) {
        this.mList = mList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_client, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.clientPhoto.setImageResource(R.drawable.request_anilza);
        viewHolder.clientName.setText(mList.get(i).getName());
        viewHolder.clientArea.setText(mList.get(i).getAdress().getArea());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_client_photo) CircleImageView clientPhoto;
        @BindView(R.id.item_client_name) TextView clientName;
        @BindView(R.id.item_client_area) TextView clientArea;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }

}
