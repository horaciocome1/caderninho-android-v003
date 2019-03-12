package com.tumblr.b1moz.caderninho003.assets;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
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

import com.tumblr.b1moz.caderninho003.R;
import com.tumblr.b1moz.caderninho003.adapters.MyStockRecyclerViewAdapter;
import com.tumblr.b1moz.caderninho003.domain.Product;
import com.tumblr.b1moz.caderninho003.domain.Stock;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class StockFragment extends Fragment {

    @BindView(R.id.fragment_stock_recyclerview) RecyclerView mRecyclerView;
    @BindView(R.id.fragment_stock_toolbar) Toolbar mToolbar;

    public StockFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stock, container, false);
        ButterKnife.bind(this, view);
        ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);
        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_stock, menu);
    }
    
    private void setUpList(Context context) {
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        mRecyclerView.setAdapter(new MyStockRecyclerViewAdapter(getListItems()));
    }

    private List<Stock> getListItems() {
        Product product;
        Stock stock;
        List<Stock> stocks = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            product = new Product();
            product.setName("Tomate Pequeno");
            stock = new Stock();
            stock.setProduct(product);
            stock.setAvailableQuantity(17);
            stocks.add(stock);

            product = new Product();
            product.setName("Darrymilk 200g");
            stock = new Stock();
            stock.setProduct(product);
            stock.setAvailableQuantity(5000);
            stocks.add(stock);

            product = new Product();
            product.setName("Montemor 5l");
            stock = new Stock();
            stock.setProduct(product);
            stock.setAvailableQuantity(4);
            stocks.add(stock);

            product = new Product();
            product.setName("Fonte da vida 5l");
            stock = new Stock();
            stock.setProduct(product);
            stock.setAvailableQuantity(76);
            stocks.add(stock);

            product = new Product();
            product.setName("Coca-cola 2l");
            stock = new Stock();
            stock.setProduct(product);
            stock.setAvailableQuantity(19);
            stocks.add(stock);

            product = new Product();
            product.setName("Nike BRS 42");
            stock = new Stock();
            stock.setProduct(product);
            stock.setAvailableQuantity(3);
            stocks.add(stock);

            product = new Product();
            product.setName("Tommy Hilfigher Polo M");
            stock = new Stock();
            stock.setProduct(product);
            stock.setAvailableQuantity(165);
            stocks.add(stock);

            product = new Product();
            product.setName("Arroz mariana 50kg");
            stock = new Stock();
            stock.setProduct(product);
            stock.setAvailableQuantity(8);
            stocks.add(stock);

            product = new Product();
            product.setName("Coca-cola 350ml");
            stock = new Stock();
            stock.setProduct(product);
            stock.setAvailableQuantity(48);
            stocks.add(stock);

            product = new Product();
            product.setName("Acucar 1kg");
            stock = new Stock();
            stock.setProduct(product);
            stock.setAvailableQuantity(6);
            stocks.add(stock);

            product = new Product();
            product.setName("Orrelhudos");
            stock = new Stock();
            stock.setProduct(product);
            stock.setAvailableQuantity(379);
            stocks.add(stock);

            product = new Product();
            product.setName("Maria nacional cafe 200g");
            stock = new Stock();
            stock.setProduct(product);
            stock.setAvailableQuantity(17);
            stocks.add(stock);
        }

        return stocks;
    }

}
