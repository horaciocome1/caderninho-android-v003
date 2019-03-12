package com.tumblr.b1moz.caderninho003.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.support.v7.widget.ThemedSpinnerAdapter;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MySpinnerAdapter extends ArrayAdapter<String> implements ThemedSpinnerAdapter {

    @BindView(android.R.id.text1) TextView mTextView;

    private final ThemedSpinnerAdapter.Helper mDropDownHelper;

    public MySpinnerAdapter(Context context, String[] objects) {
        super(context, android.R.layout.simple_list_item_1, objects);
        mDropDownHelper = new ThemedSpinnerAdapter.Helper(context);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view;

        if (convertView == null) {
            // inflar o dropdown utilizando o layoutinflater helper
            LayoutInflater inflater = mDropDownHelper.getDropDownViewInflater();
            view = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
        } else
            view = convertView;

        ButterKnife.bind(this, view);
        mTextView.setText(getItem(position));

        return view;
    }

    @Nullable
    @Override
    public Resources.Theme getDropDownViewTheme() {
        return mDropDownHelper.getDropDownViewTheme();
    }

    @Override
    public void setDropDownViewTheme(@Nullable Resources.Theme theme) {
        mDropDownHelper.setDropDownViewTheme(theme);
    }

}
