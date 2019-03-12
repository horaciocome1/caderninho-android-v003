package com.tumblr.b1moz.caderninho003.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.tumblr.b1moz.caderninho003.R;
import com.tumblr.b1moz.caderninho003.domain.Store;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyStoreRecyclerViewAdapter extends RecyclerView.Adapter<MyStoreRecyclerViewAdapter.ViewHolder> {

    List<Store> mList;

    public MyStoreRecyclerViewAdapter(List<Store> mList) {
        this.mList = mList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_store, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.storeName.setText(mList.get(position).getName());
        holder.storeAddress.setText(mList.get(position).getAddress().toString());
        holder.storeSpeciality.setText(mList.get(position).specialitiesToString());
        holder.storeRating.setRating(mList.get(position).getRating());
        holder.storePicture.setImageResource(R.drawable.mercearia_mercadinho);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.store_item_imageview) ImageView storePicture;
        @BindView(R.id.store_item_storename) TextView storeName;
        @BindView(R.id.store_item_storeaddress) TextView storeAddress;
        @BindView(R.id.store_item_storespeciality) TextView storeSpeciality;
        @BindView(R.id.store_item_ratingbar) RatingBar storeRating;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

    }

}
