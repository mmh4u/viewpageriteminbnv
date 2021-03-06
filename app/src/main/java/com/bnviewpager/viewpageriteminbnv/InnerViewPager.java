package com.bnviewpager.viewpageriteminbnv;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InnerViewPager#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InnerViewPager extends Fragment {
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;

    public InnerViewPager() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment
     * @return A new instance of fragment ViewPagerFragment.
     */
    public static InnerViewPager newInstance() {
        InnerViewPager fragment = new InnerViewPager();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_view_pager, container, false);

        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        return view;
    }


    public static class ViewPagerAdapter extends FragmentStatePagerAdapter {
        private static final int NUM_ITEMS = 2;

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        @Override
        public Fragment getItem(int position) {
            if(position == 0){
                return InnerFragment1.newInstance();
            }
            else {
                return InnerFragment2.newInstance();
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {

            if(position == 0){
                return InnerFragment1.PAGE_TITLE;
            }
            else {
                return InnerFragment2.PAGE_TITLE;
            }
        }
    }
}
