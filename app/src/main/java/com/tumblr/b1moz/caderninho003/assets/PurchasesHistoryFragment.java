package com.tumblr.b1moz.caderninho003.assets;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import com.tumblr.b1moz.caderninho003.R;
import com.tumblr.b1moz.caderninho003.adapters.MyPurchaseHistoryRecyclerViewAdapter;
import com.tumblr.b1moz.caderninho003.adapters.MySpinnerAdapter;
import com.tumblr.b1moz.caderninho003.domain.Purchase;
import com.tumblr.b1moz.caderninho003.domain.Product;
import com.tumblr.b1moz.caderninho003.domain.Store;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindArray;
import butterknife.BindView;
import butterknife.ButterKnife;

public class PurchasesHistoryFragment extends Fragment {

    @BindView(R.id.fragment_purchase_history_toolbar) Toolbar mToolbar;
    @BindView(R.id.fragment_purchase_history_recyclerview) RecyclerView mRecyclerView;
    @BindView(R.id.fragment_purchase_history_spinner) Spinner mSpinner;
    
    @BindArray(R.array.purchases_dates_spinner_data) String[] mStringDates;
    
    public PurchasesHistoryFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_purchases_history, container, false);
        ButterKnife.bind(this, view);
        ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
        mSpinner.setAdapter(new MySpinnerAdapter(mToolbar.getContext(), mStringDates));
        setUpList(view.getContext());
        return view;
    }
    
    private void setUpList(Context context) {
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        mRecyclerView.setAdapter(new MyPurchaseHistoryRecyclerViewAdapter(getClientPurchaseList(12)));
    }

    private List<Purchase> getClientPurchaseList(int size) {
        List<Purchase> purchases = new ArrayList<>();
        Purchase purchase;
        Store store;
        List<Object[]> productAndQuantity;

        for (int i = 0; i < size; i++) {
            purchase = new Purchase();
            store = new Store();
            store.setName("Rite Price Lda");
            purchase.setStore(store);
            purchase.setDate("16:15");
            purchase.setTotal(558f);

            productAndQuantity = new ArrayList<>();

            Product product = new Product();
            product.setName("Pao");
            Integer quantity = 7;
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

            purchase.setProductAndQuantity(productAndQuantity);

            purchases.add(purchase);

            //////////////////////////////////////

            purchase = new Purchase();
            store = new Store();
            store.setName("Hidro Masters");
            purchase.setStore(store);
            purchase.setDate("12/08/2018");
            purchase.setTotal(2000f);

            productAndQuantity = new ArrayList<>();

            product = new Product();
            product.setName("Yamaha Water Pump 14cv");
            quantity = 1;
            productAndQuantity.add(new Object[]{product, quantity});

            purchase.setProductAndQuantity(productAndQuantity);

            purchases.add(purchase);

            ///////////////////////////////////////

            purchase = new Purchase();
            store = new Store();
            store.setName("Diamond Ring");
            purchase.setStore(store);
            purchase.setDate("16:15");
            purchase.setTotal(12070f);

            productAndQuantity = new ArrayList<>();

            product = new Product();
            product.setName("Colar de perolas");
            quantity = 1;
            productAndQuantity.add(new Object[]{product, quantity});

            product = new Product();
            product.setName("Pulseira de rubi");
            quantity = 1;
            productAndQuantity.add(new Object[]{product, quantity});

            product = new Product();
            product.setName("Brinco de perola");
            quantity = 1;
            productAndQuantity.add(new Object[]{product, quantity});

            product = new Product();
            product.setName("Pulseira de perola");
            quantity = 1;
            productAndQuantity.add(new Object[]{product, quantity});

            purchase.setProductAndQuantity(productAndQuantity);

            purchases.add(purchase);

            ///////////////////////////////////////

            purchase = new Purchase();
            store = new Store();
            store.setName("Mobi Madi Lda.");
            purchase.setStore(store);
            purchase.setDate("09:37");
            purchase.setTotal(6900f);

            productAndQuantity = new ArrayList<>();

            product = new Product();
            product.setName("Estante American Design");
            quantity = 1;
            productAndQuantity.add(new Object[]{product, quantity});

            purchase.setProductAndQuantity(productAndQuantity);

            purchases.add(purchase);
        }

        return purchases;
    }

}
