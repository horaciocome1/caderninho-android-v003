package com.tumblr.b1moz.caderninho003.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.tumblr.b1moz.caderninho003.R;
import com.tumblr.b1moz.caderninho003.domain.Review;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyReviewListRecyclerviewAdapter extends RecyclerView.Adapter<MyReviewListRecyclerviewAdapter.ViewHolder> {

    private List<Review> mList;

    public MyReviewListRecyclerviewAdapter(List<Review> mList) {
        this.mList = mList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_review, viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.clientName.setText(mList.get(i).getCostumer().getName());
        viewHolder.ratingBar.setRating(mList.get(i).getReview());
        viewHolder.reviewComment.setText(mList.get(i).getComment());
        viewHolder.reviewDate.setText(mList.get(i).getDate());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_review_client_name) TextView clientName;
        @BindView(R.id.item_review_ratingbar) RatingBar ratingBar;
        @BindView(R.id.item_review_date) TextView reviewDate;
        @BindView(R.id.item_review_comment) TextView reviewComment;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }

}
