package com.tumblr.b1moz.caderninho003.assets;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import com.tumblr.b1moz.caderninho003.R;
import com.tumblr.b1moz.caderninho003.StoreActivity;
import com.tumblr.b1moz.caderninho003.adapters.MySpinnerAdapter;
import com.tumblr.b1moz.caderninho003.adapters.MyStoreRecyclerViewAdapter;
import com.tumblr.b1moz.caderninho003.domain.Address;
import com.tumblr.b1moz.caderninho003.domain.Store;
import com.wordpress.beendora.simplerecyclerviewtouchlistener.SimpleOnItemTouchListener;
import com.wordpress.beendora.simplerecyclerviewtouchlistener.SimpleRecyclerViewOnItemTouchListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindArray;
import butterknife.BindView;
import butterknife.ButterKnife;

public class StoresListFragment extends Fragment {

    @BindView(R.id.fragment_stores_list_recyclerview) RecyclerView mRecyclerView;
    @BindView(R.id.fragment_stores_list_toolbar) Toolbar mToolbar;
    @BindView(R.id.fragment_stores_list_spinner) Spinner mSpinner;
    
    @BindArray(R.array.sample_caregories) String[] mStringCategories;
    
    public StoresListFragment() {
    }
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stores_list, container, false);
        ButterKnife.bind(this, view);
        ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
        setHasOptionsMenu(true);
        mSpinner.setAdapter(new MySpinnerAdapter(mToolbar.getContext(), mStringCategories));
        setUpList(view.getContext());
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_stores, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
    
    private void setUpList(Context context) {
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        mRecyclerView.setAdapter(new MyStoreRecyclerViewAdapter(getStoresList(5)));
        mRecyclerView.addOnItemTouchListener(new SimpleRecyclerViewOnItemTouchListener(context,
                mRecyclerView, new SimpleOnItemTouchListener() {
            @Override
            public void onItemClick(View view, int i) {
                startActivity(new Intent(getActivity(), StoreActivity.class));
            }
    
            @Override
            public void onItemDoubleClick(View view, int i) {
        
            }
    
            @Override
            public void onItemLongPress(View view, int i) {
        
            }
        }));
    }

    private List<Store> getStoresList(int size) {
        List<Store> stores = new ArrayList<>();
        Store store;
        Address address;

        for (int i = 0; i < size; i++) {
            address = new Address(true);
            address.setArea("Central");
            address.setStreet("Av. Eduardo Mondlane");
            address.setBuildingName("Predio Artur");
            address.setFloor(5);
            address.setHouseNumber(123);
            store = new Store();
            store.setName("Salao Byt");
            store.setSpecialities(new String[]{"Dredz", "Unhas de Gel"});
            store.setRating(2.8f);
            store.setAddress(address);
            stores.add(store);

            address = new Address(true);
            address.setArea("Museu");
            address.setStreet("Av. Nhachingweya");
            address.setBuildingName("Torre 1");
            address.setFloor(5);
            address.setHouseNumber(123);
            store = new Store();
            store.setName("Mercearia Juka");
            store.setSpecialities(new String[]{"Bebidas", "Vegetais", "Frutos", "Cereais", "Peixe", "Enlatados"});
            store.setRating(0.4f);
            store.setAddress(address);
            stores.add(store);

            address = new Address(true);
            address.setArea("Alto Mae");
            address.setStreet("Av. Eduardo Mondlane");
            address.setBuildingName("Predio Celeste");
            address.setFloor(5);
            address.setHouseNumber(123);
            store = new Store();
            store.setName("Banca Sema");
            store.setSpecialities(new String[]{"Frutos"});
            store.setRating(3.5f);
            store.setAddress(address);
            stores.add(store);

            address = new Address(true);
            address.setArea("Polana");
            address.setStreet("Av. 24 de Julho");
            address.setBuildingName("Predio Azika");
            address.setFloor(5);
            address.setHouseNumber(123);
            store = new Store();
            store.setName("Moda Fashion");
            store.setSpecialities(new String[]{"Roupa usada", "Mobilia usada"});
            store.setRating(4.2f);
            store.setAddress(address);
            stores.add(store);
        }

        return stores;
    }
    
}
