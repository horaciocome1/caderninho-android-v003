package com.tumblr.b1moz.caderninho003.assets;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tumblr.b1moz.caderninho003.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeFragment extends Fragment {

    @BindView(R.id.fragment_home_toolbar) Toolbar mToolbar;

    @OnClick({R.id.fragment_home_costumers_button, R.id.fragment_home_income_button, R.id.fragment_home_reviews_button, R.id.fragment_home_products_button})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fragment_home_costumers_button:
                // carregar a lista de clientes
        }
    }

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);
        return view;
    }

}
