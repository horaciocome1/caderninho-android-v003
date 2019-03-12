package com.tumblr.b1moz.caderninho003.assets;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tumblr.b1moz.caderninho003.Helpers.Constants;
import com.tumblr.b1moz.caderninho003.R;
import com.tumblr.b1moz.caderninho003.adapters.MyRequestRecyclerViewAdapter;
import com.tumblr.b1moz.caderninho003.adapters.MySpinnerAdapter;
import com.tumblr.b1moz.caderninho003.domain.Address;
import com.tumblr.b1moz.caderninho003.domain.Costumer;
import com.tumblr.b1moz.caderninho003.domain.Product;
import com.tumblr.b1moz.caderninho003.domain.Request;
import com.tumblr.b1moz.caderninho003.domain.Store;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindArray;
import butterknife.BindView;
import butterknife.ButterKnife;

public class RequestsFragment extends Fragment {

    @BindView(R.id.fragment_requests_toolbar) Toolbar mToolbar;
    @BindView(R.id.fragment_requests_spinner) AppCompatSpinner mSpinner;
    @BindView(R.id.fragment_requests_recyclerview) RecyclerView mRecyclerView;
    
    @BindArray(R.array.requests_spinner_data) String[] mSpinnerData;

    private boolean IS_SELLER;

    public RequestsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setIS_SELLER(getArguments().getInt(Constants.PASSING_USER_ACCOUNT_TYPE_KEY, -1));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_requests, container, false);
        ButterKnife.bind(this, view);
        ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
        setHasOptionsMenu(true);
        mSpinner.setAdapter(new MySpinnerAdapter(mToolbar.getContext(), mSpinnerData));
        setUpList(view.getContext());
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_requests, menu);
    }
    
    private void setIS_SELLER(int account_type) {
        if (account_type == Constants.USER_ACCOUNT_TYPE_SELLER)
            IS_SELLER = true;
        else if (account_type == Constants.USER_ACCOUNT_TYPE_CARRIER)
            IS_SELLER = false;
    }
    
    private void setUpList(Context context) {
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        if (IS_SELLER)
            // Set the adapter for a seller
        mRecyclerView.setAdapter(new MyRequestRecyclerViewAdapter(getRequestList(12), Constants.USER_ACCOUNT_TYPE_SELLER));
        else
            // Set the adapter for a carrier
        mRecyclerView.setAdapter(new MyRequestRecyclerViewAdapter(getRequestList(12), Constants.USER_ACCOUNT_TYPE_CARRIER));
    }

    private List<Request> getRequestList(int size) {
        List<Request> requests = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Address address = new Address(true);
            address.setArea("Central");
            address.setBuildingName("Predio Celest");
            address.setFloor(3);
            address.setHouseNumber(34);
            address.setStreet("Av. Eduardo Mondlane");

            Costumer costumer = new Costumer();
            costumer.setName("Anilza Cynthia");
            costumer.setAdress(address);

            Product product = new Product();
            product.setName("Pao");
            Integer quantity = 7;

            List<Object[]> productAndQuantity = new ArrayList<>();
            productAndQuantity.add(new Object[]{product, quantity});

            product = new Product();
            product.setName("Montemor 5 l");
            quantity = 3;
            productAndQuantity.add(new Object[]{product, quantity});

            product = new Product();
            product.setName("Darymilk Tablet 200 g");
            quantity = 40;
            productAndQuantity.add(new Object[]{product, quantity});

            product = new Product();
            product.setName("Blusa cava");
            quantity = 1;
            productAndQuantity.add(new Object[]{product, quantity});

            product = new Product();
            product.setName("Sprite 2 l");
            quantity = 1;
            productAndQuantity.add(new Object[]{product, quantity});

            product = new Product();
            product.setName("Acucar refinado 1 kg");
            quantity = 4;
            productAndQuantity.add(new Object[]{product, quantity});

             Store store = new Store();
            address = new Address(true);
            address.setArea("Alto Mae");
            store.setAddress(address);

            Request request = new Request();
            request.setStore(store);
            request.setCostumer(costumer);
            request.setProductQuantity(productAndQuantity);
            requests.add(request);
        }
        return requests;
    }

}
