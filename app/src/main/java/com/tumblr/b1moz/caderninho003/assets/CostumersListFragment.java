package com.tumblr.b1moz.caderninho003.assets;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tumblr.b1moz.caderninho003.R;
import com.tumblr.b1moz.caderninho003.adapters.MyClientListRecyclerViewAdapter;
import com.tumblr.b1moz.caderninho003.domain.Address;
import com.tumblr.b1moz.caderninho003.domain.Costumer;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CostumersListFragment extends Fragment {

    private RecyclerView mRecyclerView;

    public CostumersListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.general_recyclerview, container, false);
        if (view instanceof RecyclerView) {
            mRecyclerView = (RecyclerView) view;
            mRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
            mRecyclerView.setAdapter(new MyClientListRecyclerViewAdapter(getClientList(12)));
        }
        return view;
    }

    private List<Costumer> getClientList(final int size) {
        List<Costumer> costumers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Costumer costumer = new Costumer();
            costumer.setName("Anilza Cynthia");
            Address address = new Address(false);
            address.setArea("Matendene");
            costumer.setAdress(address);
            costumers.add(costumer);
        }
        return costumers;
    }

}
