package com.tumblr.b1moz.caderninho003.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tumblr.b1moz.caderninho003.R;
import com.tumblr.b1moz.caderninho003.domain.Stock;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyStockRecyclerViewAdapter extends RecyclerView.Adapter<MyStockRecyclerViewAdapter.ViewHolder> {

    private List<Stock> mList;

    public MyStockRecyclerViewAdapter(List<Stock> stocks) {
        mList = stocks;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_stock, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.productName.setText(mList.get(position).getProduct().getName());
        holder.availableQuantity.setText(String.valueOf(mList.get(position).getAvailableQuantity()));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.stock_product_name) TextView productName;
        @BindView(R.id.stock_available_quantity) TextView availableQuantity;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

    }

}
