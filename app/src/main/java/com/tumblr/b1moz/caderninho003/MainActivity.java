package com.tumblr.b1moz.caderninho003;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.tumblr.b1moz.caderninho003.Helpers.Constants;
import com.tumblr.b1moz.caderninho003.assets.CarrierProfileFragment;
import com.tumblr.b1moz.caderninho003.assets.CostumerProfileFragment;
import com.tumblr.b1moz.caderninho003.assets.CostumersAndReviewsFragment;
import com.tumblr.b1moz.caderninho003.assets.HomeFragment;
import com.tumblr.b1moz.caderninho003.assets.NotificationsFragment;
import com.tumblr.b1moz.caderninho003.assets.PurchasesHistoryFragment;
import com.tumblr.b1moz.caderninho003.assets.RequestsFragment;
import com.tumblr.b1moz.caderninho003.assets.SalesHistoryFragment;
import com.tumblr.b1moz.caderninho003.assets.SellerProfileFragment;
import com.tumblr.b1moz.caderninho003.assets.StockFragment;
import com.tumblr.b1moz.caderninho003.assets.StoresListFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.activity_main_bottom_navigation) BottomNavigationView mBottomNavigation;

    // SELLER
    SalesHistoryFragment mSalesHistoryFragment;
    StockFragment mStockFragment;
    SellerProfileFragment mSellerProfileFragment;
    HomeFragment mHomeFragment;

    RequestsFragment mRequestsFragment;

    // COSTUMER
    StoresListFragment mStoresListFragment;
    PurchasesHistoryFragment mPurchasesHistoryFragment;
    CostumerProfileFragment mCostumerProfileFragment;

    NotificationsFragment mNotificationsFragment;

    // CARRIER
    CostumersAndReviewsFragment mCostumersAndReviewsFragment;
    CarrierProfileFragment mCarrierProfileFragment;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            return setupFragment(whichFragment(item.getItemId()));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mBottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        startActivityForResult(new Intent(this, SignInActivity.class), Constants.PASSING_USER_ACCOUNT_TYPE_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constants.PASSING_USER_ACCOUNT_TYPE_REQUEST_CODE && resultCode == RESULT_OK)
            updateBottomNavigationMenu(data.getIntExtra(Constants.PASSING_USER_ACCOUNT_TYPE_KEY, -1));
        else
            finish();
    }

    @Override
    public void onBackPressed() {
        finish();
    }
    
    private Fragment whichFragment(int id) {
        switch (id) {
            case R.id.navigation_home:
                if (mHomeFragment == null)
                    mHomeFragment = new HomeFragment();
                return mHomeFragment;
                
            case R.id.navigation_requests:
                if (mRequestsFragment == null) {
                    Bundle bundle = new Bundle();
                    bundle.putInt(Constants.PASSING_USER_ACCOUNT_TYPE_KEY, Constants.USER_ACCOUNT_TYPE_SELLER);
                    mRequestsFragment = new RequestsFragment();
                    mRequestsFragment.setArguments(bundle);
                }
                return mRequestsFragment;
                
            case R.id.navigation_seller_profile:
                if (mSellerProfileFragment == null)
                    mSellerProfileFragment = new SellerProfileFragment();
                return mSellerProfileFragment;
                
            case R.id.navigation_stocks:
                if (mStockFragment == null)
                    mStockFragment = new StockFragment();
                return mStockFragment;
                
            case R.id.navigation_sales:
                if (mSalesHistoryFragment == null)
                    mSalesHistoryFragment = new SalesHistoryFragment();
                return mSalesHistoryFragment;
                
            case R.id.navigation_stores:
                if (mStoresListFragment == null)
                    mStoresListFragment = new StoresListFragment();
                return mStoresListFragment;
                
            case R.id.navigation_notifications:
                if (mNotificationsFragment == null) {
                    Bundle bundle = new Bundle();
                    bundle.putInt(Constants.PASSING_USER_ACCOUNT_TYPE_KEY, Constants.USER_ACCOUNT_TYPE_COSTUMER);
                    mNotificationsFragment = new NotificationsFragment();
                    mNotificationsFragment.setArguments(bundle);
                }
                return mNotificationsFragment;
                
            case R.id.navigation_purchases_history_costumer:
                if (mPurchasesHistoryFragment == null)
                    mPurchasesHistoryFragment = new PurchasesHistoryFragment();
                return mPurchasesHistoryFragment;
                
            case R.id.navigation_profile_costumer:
                if (mCostumerProfileFragment == null)
                    mCostumerProfileFragment = new CostumerProfileFragment();
                return mCostumerProfileFragment;
                
            case R.id.navigation_requests_carrier:
                if (mRequestsFragment == null) {
                    Bundle bundle = new Bundle();
                    bundle.putInt(Constants.PASSING_USER_ACCOUNT_TYPE_KEY, Constants.USER_ACCOUNT_TYPE_CARRIER);
                    mRequestsFragment = new RequestsFragment();
                    mRequestsFragment.setArguments(bundle);
                }
                return mRequestsFragment;
                
            case R.id.navigation_notifications_carrier:
                if (mNotificationsFragment == null) {
                    Bundle bundle = new Bundle();
                    bundle.putInt(Constants.PASSING_USER_ACCOUNT_TYPE_KEY, Constants.USER_ACCOUNT_TYPE_CARRIER);
                    mNotificationsFragment = new NotificationsFragment();
                    mNotificationsFragment.setArguments(bundle);
                }
                return mNotificationsFragment;
                
            case R.id.navigation_costumers_and_reviews_carrier:
                if (mCostumersAndReviewsFragment == null)
                    mCostumersAndReviewsFragment = new CostumersAndReviewsFragment();
                return mCostumersAndReviewsFragment;
                
            case R.id.navigation_profile_carrier:
                if (mCarrierProfileFragment == null)
                    mCarrierProfileFragment = new CarrierProfileFragment();
                return mCarrierProfileFragment;
        }
        return null;
    }

    private boolean setupFragment(Fragment fragment) {
        if (fragment == null)
            return false;
        else {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_fragment_container, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
            return true;
        }
    }
    
    private void updateBottomNavigationMenu(int account_type) {
        if (!(mBottomNavigation.getMenu() == null))
            switch (account_type) {
                case Constants.USER_ACCOUNT_TYPE_COSTUMER:
                    mBottomNavigation.inflateMenu(R.menu.menu_navigation_costumer);
                    mBottomNavigation.setSelectedItemId(R.id.navigation_stores);
                    break;
                case Constants.USER_ACCOUNT_TYPE_SELLER:
                    mBottomNavigation.inflateMenu(R.menu.menu_navigation_seller);
                    mBottomNavigation.setSelectedItemId(R.id.navigation_home);
                    break;
                case Constants.USER_ACCOUNT_TYPE_CARRIER:
                    mBottomNavigation.inflateMenu(R.menu.menu_navigation_carrier);
                    mBottomNavigation.setSelectedItemId(R.id.navigation_requests_carrier);
                    break;
            }
    }
    
}
