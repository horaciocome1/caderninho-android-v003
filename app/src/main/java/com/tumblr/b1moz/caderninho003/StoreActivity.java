package com.tumblr.b1moz.caderninho003;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.tumblr.b1moz.caderninho003.adapters.MyCategoriesRecyclerViewAdapter;
import com.tumblr.b1moz.caderninho003.adapters.MyCoverRecyclerViewAdapter;
import com.tumblr.b1moz.caderninho003.domain.Category;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class StoreActivity extends AppCompatActivity {
    
    @BindView(R.id.fragment_store_toolbar) Toolbar mToolbar;
    @BindView(R.id.fragment_store_cover_recyclerview) RecyclerView mRecyclerViewCover;
    @BindView(R.id.fragment_store_photo_imageview) CircleImageView mImageViewPhoto;
    @BindView(R.id.fragment_store_name_textview) TextView mTextViewName;
    @BindView(R.id.fragment_store_description_textview) TextView mTextViewDescription;
    @BindView(R.id.fragment_store_ratingbar) RatingBar mRatingBar;
    @BindView(R.id.fragment_store_categories_recyclerview) RecyclerView mRecyclerViewCategories;
    
    @OnClick({R.id.fragment_store_map_button, R.id.fragment_store_email_button, R.id
        .fragment_store_call_button, R.id.fragment_store_rate_button, R.id
        .fragment_store_share_button})
    void onClick(View view) {
        Toast.makeText(this, "yeah", Toast.LENGTH_SHORT).show();
    }
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        bindData();
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_stores, menu);
        return super.onCreateOptionsMenu(menu);
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    private void bindData() {
        getSupportActionBar().setTitle("Fashion Ink Lda.");
        mTextViewName.setText("Fashion Ink Lda.");
        mTextViewDescription.setText("Esta e uma loja muito bonita especializada em aderecos de moda que fica numa zona chique de duer. nem da pra acreditar que tenhamos uma coisa destas no nosso pais. para desfrutar dela venha com pelo menos tres cartos. porque o valor gasto minimo e o dobro do limite de levantamento para muitos bancos.");
        mRatingBar.setRating(2.56f);
        mImageViewPhoto.setImageResource(R.drawable.store_logo);
        setUpCover();
        setUpList();
    }
    
    private void setUpCover() {
        mRecyclerViewCover.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager
                .HORIZONTAL, false));
        mRecyclerViewCover.setAdapter(new MyCoverRecyclerViewAdapter(new int[]{R.drawable
                .inside_store0, R.drawable.inside_store1, R.drawable.inside_store2, R.drawable.inside_store3, R.drawable.inside_store4}));
        (new PagerSnapHelper()).attachToRecyclerView(mRecyclerViewCover);
    }
    
    private void setUpList() {
        mRecyclerViewCategories.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false));
        mRecyclerViewCategories.setHasFixedSize(true);
        mRecyclerViewCategories.setAdapter(new MyCategoriesRecyclerViewAdapter(getFakeCategories
                (12)));
    }
    
    private List<Category> getFakeCategories(int size) {
        List<Category> categories = new ArrayList<>();
        Category c1 = new Category(R.drawable.category_jeans, "Calcas", 1088);
        categories.add(c1);
        c1 = new Category(R.drawable.category_shirt, "Camisas", 54);
        categories.add(c1);
        c1 = new Category(R.drawable.category_cap, "Chapeus", 33);
        categories.add(c1);
        c1 = new Category(R.drawable.category_suits, "Gravatas", 690);
        categories.add(c1);
        c1 = new Category(R.drawable.category_sunglasses, "Oculos", 21);
        categories.add(c1);
        c1 = new Category(R.drawable.category_boot, "Sapatos", 364);
        categories.add(c1);
        return categories;
        
        
    }
    
}
