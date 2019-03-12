package com.tumblr.b1moz.caderninho003.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tumblr.b1moz.caderninho003.Helpers.Constants;
import com.tumblr.b1moz.caderninho003.R;
import com.tumblr.b1moz.caderninho003.domain.Request;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;


public class MyRequestRecyclerViewAdapter extends RecyclerView.Adapter<MyRequestRecyclerViewAdapter.ViewHolder> {

    private final List<Request> mList;
    private final int ACCOUNT_TYPE;

    public MyRequestRecyclerViewAdapter(List<Request> mList, int account_type) {
        this.mList = mList;
        this.ACCOUNT_TYPE = account_type;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_request, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.clientPicture.setImageResource(R.drawable.request_anilza);
        holder.clientName.setText(mList.get(position).getCostumer().getName());
        if (ACCOUNT_TYPE == Constants.USER_ACCOUNT_TYPE_SELLER) {
            holder.clientAddress.setText(mList.get(position).getCostumer().getAdress().toString());
            holder.clientRequest.setText(mList.get(position).toString());
        } else if (ACCOUNT_TYPE == Constants.USER_ACCOUNT_TYPE_CARRIER) {
            holder.clientAddress.setText(mList.get(position).getStore().getAddress().getArea());
            holder.clientRequest.setText(mList.get(position).getCostumer().getAdress().getArea());
        }
        holder.requestDeelay.setText("5 horas"); // implementar diferenca entre a data actual e a data do pedido
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.requests_client_picture) CircleImageView clientPicture;
        @BindView(R.id.requests_client_name) TextView clientName;
        @BindView(R.id.requests_client_address) TextView clientAddress;
        @BindView(R.id.requests_client_request) TextView clientRequest;
        @BindView(R.id.requests_request_deelay) TextView requestDeelay;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

    }

}
