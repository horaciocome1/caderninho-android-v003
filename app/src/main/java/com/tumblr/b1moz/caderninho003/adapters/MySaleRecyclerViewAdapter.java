package com.tumblr.b1moz.caderninho003.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tumblr.b1moz.caderninho003.R;
import com.tumblr.b1moz.caderninho003.domain.Sale;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MySaleRecyclerViewAdapter extends RecyclerView.Adapter<MySaleRecyclerViewAdapter.ViewHolder> {

    private final List<Sale> mList;

    public MySaleRecyclerViewAdapter(List<Sale> sales) {
        mList = sales;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sale, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.saleProducts.setText(mList.get(position).toString());
        holder.saleDate.setText(mList.get(position).getDateString());
        holder.saleClientName.setText(mList.get(position).getCostumer().getName());
        holder.saleTotal.setText(String.valueOf(mList.get(position).getTotal()) + " MT");
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.sale_products) TextView saleProducts;
        @BindView(R.id.sale_date) TextView saleDate;
        @BindView(R.id.sale_total) TextView saleTotal;
        @BindView(R.id.sale_client_name) TextView saleClientName;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

    }

}
