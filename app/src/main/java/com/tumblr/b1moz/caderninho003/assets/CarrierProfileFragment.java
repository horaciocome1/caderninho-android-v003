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
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.tumblr.b1moz.caderninho003.R;
import com.tumblr.b1moz.caderninho003.adapters.MyCoverRecyclerViewAdapter;
import com.tumblr.b1moz.caderninho003.domain.Address;
import com.tumblr.b1moz.caderninho003.domain.CarPlate;
import com.tumblr.b1moz.caderninho003.domain.Carrier;
import com.tumblr.b1moz.caderninho003.domain.Phone;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class CarrierProfileFragment extends Fragment {

    @BindView(R.id.fragment_carrier_profile_toolbar) Toolbar mToolbar;
    @BindView(R.id.fragment_carrier_profile_recyclerview_cover) RecyclerView mCoverRecyclerView;
    @BindView(R.id.fragment_carrier_profile_photo) CircleImageView mProfilePhoto;
    @BindView(R.id.fragment_carrier_profile_name) TextView mTextViewName;
    @BindView(R.id.fragment_carrier_profile_route) TextView mTextViewRoute;
    @BindView(R.id.fragment_carrier_profile_plate) TextView mTextViewCarPlate;
    @BindView(R.id.fragment_carrier_profile_clients) TextView mTextViewTotalClients;
    @BindView(R.id.fragment_carrier_profile_rating) TextView mTextViewProfileRating;
    @BindView(R.id.fragment_carrier_profile_delivers) TextView mTextViewTotalDelivers;
    @BindView(R.id.fragment_carrier_profile_more_details_listview) ListView mMoreDetailsList;

    private Carrier mCarrier;

    public CarrierProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_carrier_profile, container, false);
        ButterKnife.bind(this, view);
        ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);
        bindData(view.getContext());
        return view;
    }

    private void fakeCarrierData() {
        Address address = new Address(true);

        if (mCarrier == null)
            mCarrier = new Carrier();
        mCarrier.setName("Ezamuel Zan Marie");

        address.setArea("Baixa");
        mCarrier.setAddress1(address);

        address = new Address(true);
        address.setArea("Matola Gare");
        mCarrier.setAddress2(address);

        CarPlate plate = new CarPlate("AAC", "984", "MC");
        mCarrier.setCarPlate(plate);

        mCarrier.setTotalClients(572);
        mCarrier.setRating(3.8f);
        mCarrier.setTotalDelivers(4083);
        mCarrier.setPhone(new Phone(84, 3845597));
        mCarrier.setEmail("emarie@mail.co.mz");
        mCarrier.setSex('m');
        mCarrier.setBirthday("12 de Junho 1967");
    }
    
    private void bindData(Context context) {
        fakeCarrierData();
        mTextViewName.setText(mCarrier.getName());
        mTextViewRoute.setText(mCarrier.getAddress1().getArea() + " - " + mCarrier.getAddress2().getArea());
        mTextViewCarPlate.setText(mCarrier.getCarPlate().toString());
        mTextViewTotalClients.setText(String.valueOf(mCarrier.getTotalClients()));
        mTextViewProfileRating.setText(String.valueOf(mCarrier.getRating()));
        mTextViewTotalDelivers.setText(String.valueOf(mCarrier.getTotalDelivers()));
        mMoreDetailsList.setAdapter(new ArrayAdapter<>(context, android.R.layout.simple_list_item_1,
                mCarrier.getMoreDetailsList()));
        mCoverRecyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager
                .HORIZONTAL, false));
        mCoverRecyclerView.setAdapter(new MyCoverRecyclerViewAdapter(new int[]{R.drawable.driver_car0, R.drawable.driver_car1, R.drawable.driver_car2,
                R.drawable.driver_car3, R.drawable.driver_car4}));
        (new PagerSnapHelper()).attachToRecyclerView(mCoverRecyclerView);
        mProfilePhoto.setImageResource(R.drawable.driver_photo);
    }

}
