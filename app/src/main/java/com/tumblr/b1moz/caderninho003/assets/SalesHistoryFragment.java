package com.tumblr.b1moz.caderninho003.assets;

import android.content.Context;
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
import com.tumblr.b1moz.caderninho003.adapters.MySaleRecyclerViewAdapter;
import com.tumblr.b1moz.caderninho003.adapters.MySpinnerAdapter;
import com.tumblr.b1moz.caderninho003.domain.Costumer;
import com.tumblr.b1moz.caderninho003.domain.Product;
import com.tumblr.b1moz.caderninho003.domain.Sale;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindArray;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SalesHistoryFragment extends Fragment {

    @BindView(R.id.fragment_sales_history_toolbar) Toolbar mToolbar;
    @BindView(R.id.fragment_sales_history_spinner) Spinner mSpinner;
    @BindView(R.id.fragment_sales_history_recyclerview) RecyclerView mRecyclerView;
    
    @OnClick(R.id.fragment_sales_history_fab)
    void onClick(View view) {
    
    }
    
    @BindArray(R.array.purchases_dates_spinner_data) String[] mStringDates;

    public SalesHistoryFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sales_history, container, false);
        ButterKnife.bind(this, view);
        ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
        setHasOptionsMenu(true);
        mSpinner.setAdapter(new MySpinnerAdapter(mToolbar.getContext(), mStringDates));
        setUpList(view.getContext());
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_sales_history, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
    
    private void setUpList(Context context) {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        mRecyclerView.setAdapter(new MySaleRecyclerViewAdapter(getItemList(10)));
        mRecyclerView.setHasFixedSize(true);
    }

    private List<Sale> getItemList(int size) {
        List<Sale> sales = new ArrayList<>();
        Product product;
        Costumer costumer;
        Sale sale;
        List<Object[]> productAndQuantity;
        Integer quantity;

        for (int i = 0; i < size; i++) {
            sale = new Sale();
            sale.setDateString("17/08/2018");
            costumer = new Costumer();
            costumer.setName("Jose Mateus");
            sale.setCostumer(costumer);
            sale.setTotal(550);

            product = new Product();
            product.setName("Pao");
            quantity = 7;

            productAndQuantity = new ArrayList<>();
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
            sale.setProductQuantity(productAndQuantity);

            sales.add(sale);

            sale = new Sale();
            sale.setDateString("15/06/2018");
            costumer = new Costumer();
            costumer.setName("");
            sale.setCostumer(costumer);
            sale.setTotal(1830);

            product = new Product();
            product.setName("Pao");
            quantity = 7;

            productAndQuantity = new ArrayList<>();
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
            sale.setProductQuantity(productAndQuantity);

            sales.add(sale);

            sale = new Sale();
            sale.setDateString("09/06/2018");
            costumer = new Costumer();
            costumer.setName("Lucas Re");
            sale.setCostumer(costumer);
            sale.setTotal(33487);

            product = new Product();
            product.setName("Pao");
            quantity = 7;

            productAndQuantity = new ArrayList<>();
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
            sale.setProductQuantity(productAndQuantity);

            sales.add(sale);

            sale = new Sale();
            sale.setDateString("11/05/2018");
            costumer = new Costumer();
            costumer.setName("Antonio Rafael");
            sale.setCostumer(costumer);
            sale.setTotal(550);

            product = new Product();
            product.setName("Pao");
            quantity = 7;

            productAndQuantity = new ArrayList<>();
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
            sale.setProductQuantity(productAndQuantity);

            sales.add(sale);
        }

        return sales;
    }

}
