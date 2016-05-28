package com.timer.rorschak.dogather;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.viewpagerindicator.CirclePageIndicator;
import java.util.ArrayList;

/**
 * Created by Rorschak1 on 5/26/16.
 */
public class UserWelcomeFragment extends Fragment {

    protected ViewPager mPager;

    /**
     * Following is adapter to add or remove views from the pager
     */
    protected class UserPagerAdapter extends PagerAdapter {
        private ArrayList<View> mViews = new ArrayList<>();
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = mViews.get(position);
            container.addView(view);
            return view;
        }
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mViews.get(position));
        }
        @Override
        public int getCount() {
            return mViews.size();
        }
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view.equals(object);
        }
        @Override
        public int getItemPosition(Object object) {
            return mViews.indexOf(object);
        }
        public void addView(View view) {
            mViews.add(view);
        }
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        UserPagerAdapter userWelcomeAdapter= new UserPagerAdapter();

        //inflate the view for fragment and add the page layouts to it
        View returnView = inflater.inflate(R.layout.userwelcome, null);
        mPager=(ViewPager) returnView.findViewById(R.id.pager);
        userWelcomeAdapter.addView(LayoutInflater.from(mPager.getContext()).inflate(R.layout.user_page1, null));
        userWelcomeAdapter.addView(LayoutInflater.from(mPager.getContext()).inflate(R.layout.user_pag2, null));
        userWelcomeAdapter.addView(LayoutInflater.from(mPager.getContext()).inflate(R.layout.user_page3, null));
        mPager.setAdapter(userWelcomeAdapter);
        final CirclePageIndicator paginator = (CirclePageIndicator) returnView.findViewById(R.id.titles);

        paginator.setViewPager(mPager);

        return returnView;
    }
}
