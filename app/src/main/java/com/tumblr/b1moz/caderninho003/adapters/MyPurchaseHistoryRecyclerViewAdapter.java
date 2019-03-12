package com.tumblr.b1moz.caderninho003.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tumblr.b1moz.caderninho003.R;
import com.tumblr.b1moz.caderninho003.domain.Purchase;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyPurchaseHistoryRecyclerViewAdapter extends RecyclerView.Adapter<MyPurchaseHistoryRecyclerViewAdapter.ViewHolder> {

    private final List<Purchase> mList;

    public MyPurchaseHistoryRecyclerViewAdapter(List<Purchase> items) {
        mList = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_purchase, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.storename.setText(mList.get(position).getStore().getName());
        holder.products.setText(mList.get(position).toString());
        holder.total.setText(String.valueOf(mList.get(position).getTotal()) + " MT");
        holder.date.setText(mList.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_clientpurchase_storename) TextView storename;
        @BindView(R.id.item_clientpurchase_products) TextView products;
        @BindView(R.id.item_clientpurchase_total) TextView total;
        @BindView(R.id.item_clientpurchase_date) TextView date;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

    }

}
