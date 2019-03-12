package com.tumblr.b1moz.caderninho003.assets;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tumblr.b1moz.caderninho003.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class CostumerProfileFragment extends Fragment {

    @BindView(R.id.fragment_costumer_profile_toolbar) Toolbar mToolbar;
    @BindView(R.id.fragment_costumer_profile_photo) CircleImageView mImageViewProfilePhoto;
    @BindView(R.id.fragment_costumer_profile_cover) ImageView mImageViewProfileCover;
    @BindView(R.id.fragment_costumer_profile_name) TextView mTextViewName;
    @BindView(R.id.fragment_costumer_profile_address) TextView mTextViewAddress;
    @BindView(R.id.fragment_costumer_profile_email) TextView mTextViewEmail;
    @BindView(R.id.fragment_costumer_profile_phone) TextView mTextViewPhone;
    
    @OnClick({R.id.fragment_costumer_profile_edit_profile_button, R.id
            .fragment_costumer_profile_advanced_options_button, R.id.fragment_costumer_profile_logout_button})
    void onClick(View view) {}

    public CostumerProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_costumer_profile, container, false);
        ButterKnife.bind(this, view);
        ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);
        bindData();
        return view;
    }
    
    private void bindData() {
        mImageViewProfilePhoto.setImageResource(R.drawable.clientaccount_anilza);
        mTextViewName.setText("Anilza Cynthia");
        mTextViewAddress.setText("Central, Av. Eduardo Mondlane, Predio Celeste, 3' piso, porta 34");
        mTextViewEmail.setText("acynthia@mail.co.mz");
        mTextViewPhone.setText("84 234 0987");
    }

}
