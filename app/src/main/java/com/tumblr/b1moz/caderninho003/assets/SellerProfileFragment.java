package com.tumblr.b1moz.caderninho003.assets;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.tumblr.b1moz.caderninho003.R;
import com.tumblr.b1moz.caderninho003.adapters.MyCoverRecyclerViewAdapter;
import com.tumblr.b1moz.caderninho003.domain.Address;
import com.tumblr.b1moz.caderninho003.domain.Store;
import com.tumblr.b1moz.caderninho003.domain.StoreAdministrator;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class SellerProfileFragment extends Fragment {

    @BindView(R.id.fragment_seller_profile_toolbar) Toolbar mToolbar;
    @BindView(R.id.fragment_seller_profile_name_textview) TextView mTextViewName;
    @BindView(R.id.fragment_seller_profile_address_textview) TextView mTextViewAddress;
    @BindView(R.id.fragment_seller_profile_speciality_textview) TextView mTextViewSpeciality;
    @BindView(R.id.fragment_seller_profile_total_clients_textview) TextView mTextViewTotalClients;
    @BindView(R.id.fragment_seller_profile_rating_textview) TextView mTextViewRating;
    @BindView(R.id.fragment_seller_profile_administrator_listview) ListView mAdministratorDetailsList;
    @BindView(R.id.fragment_seller_profile_cover_recyclerview) RecyclerView mRecyclerViewCover;
    @BindView(R.id.fragment_seller_profile_photo) CircleImageView mPhoto;
    
    @OnClick({R.id.fragment_seller_profile_advanced_options_button, R.id
            .fragment_seller_profile_edit_profile_button})
    void onClick(View view) {
    
    }

    private Store mStore;
    private Address mStoreAddress;
    private StoreAdministrator mStoreAdministrator;

    public SellerProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_seller_profile, container, false);
        ButterKnife.bind(this, view);
        ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);
        setHasOptionsMenu(true);
        bindData(view.getContext());
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_costumer_profile, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
    
    private void bindData(Context context) {
        fakeStoreData();
        mTextViewName.setText(mStore.getName());
        mTextViewAddress.setText(mStore.getAddress().toString());
        mTextViewSpeciality.setText(mStore.specialitiesToString());
        mTextViewTotalClients.setText(String.valueOf(mStore.getTotalStoreClients()));
        mTextViewRating.setText(String.valueOf(mStore.getRating()));
        mAdministratorDetailsList.setAdapter(new ArrayAdapter<>(context, android.R.layout
                .simple_list_item_1, mStore.getStoreAdministrator()
                .getAdministratorDetailsList()));
        mPhoto.setImageResource(R.drawable.store_logo);
        setUpCover(context);
    }
    
    private void setUpCover(Context context) {
        mRecyclerViewCover.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager
                .HORIZONTAL, false));
        mRecyclerViewCover.setAdapter(new MyCoverRecyclerViewAdapter(new int[]{R.drawable.inside_store0, R.drawable.inside_store1,
                R.drawable.inside_store2, R.drawable.inside_store3, R.drawable.inside_store4}));
        (new PagerSnapHelper()).attachToRecyclerView(mRecyclerViewCover);
    }

    private void fakeStoreData() {
        if (mStoreAdministrator == null)
            mStoreAdministrator = new StoreAdministrator();
        mStoreAdministrator.setName("Joao Antonio Timeu");
        mStoreAdministrator.setEmailAddress("jtimeu@ffink.co.mz");
        mStoreAdministrator.setGender('m');
        mStoreAdministrator.setBirthday("28 de Fevereiro de 2004");

        if (mStoreAddress == null)
            mStoreAddress = new Address(true);
        mStoreAddress.setArea("Alto Mae");
        mStoreAddress.setStreet("Av. Eduardo Mondlane");
        mStoreAddress.setBuildingName("Predio Celeste");
        mStoreAddress.setFloor(5);
        mStoreAddress.setHouseNumber(123);

        if (mStore == null)
            mStore = new Store();
        mStore.setName("Fashion Fash ink Lda.");
        mStore.setAddress(mStoreAddress);
        mStore.setStoreAdministrator(mStoreAdministrator);
        mStore.setTotalStoreClients(4309);
        mStore.setRating(2.7f);
        mStore.setSpecialities(new String[]{"Sapatilhas Sport, Roupa Sport"});
    }

}
