package com.tumblr.b1moz.caderninho003.assets;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tumblr.b1moz.caderninho003.R;
import com.tumblr.b1moz.caderninho003.adapters.MyFragmentStatePagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CostumersAndReviewsFragment extends Fragment {

    @BindView(R.id.fragment_costumers_toolbar) Toolbar mToolbar;
    @BindView(R.id.fragment_costumers_tablayout) TabLayout mTabLayout;
    @BindView(R.id.fragment_costumers_viewpager) ViewPager mViewPager;

    public CostumersAndReviewsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_costumers_and_reviews, container, false);
        ButterKnife.bind(this, view);
        ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);
        setupViewPager(mViewPager);
        mTabLayout.setupWithViewPager(mViewPager);
        return view;
    }

    private void setupViewPager(ViewPager viewPager) {
        MyFragmentStatePagerAdapter adapter = new MyFragmentStatePagerAdapter(getChildFragmentManager());
        adapter.addFragment(new CostumersListFragment(), "Clientes");
        adapter.addFragment(new ReviewsListFragment(), "Criticas");
        viewPager.setAdapter(adapter);
    }

}
