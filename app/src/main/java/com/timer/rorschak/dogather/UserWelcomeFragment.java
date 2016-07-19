package com.timer.rorschak.dogather;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.viewpagerindicator.CirclePageIndicator;
import java.util.ArrayList;

/**
 * UserWelcomeFragment.java - Base fragment for 3 welcome screens containing layout for pager and indicator
 * @author  Rorschak1
 * @version 1.0
 */

public class UserWelcomeFragment extends Fragment {

    private ViewPager mPager;
    private Button mUserButton;
    private UserPagerAdapter mUserAdapter;

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

        Log.d("Called oncreate","once created ");
        /**inflate the view for fragment and add the page layouts to it*/
        View returnView = inflater.inflate(R.layout.userwelcome, null);
        mUserAdapter= new UserPagerAdapter();
        mUserButton = (Button) returnView.findViewById(R.id.welcome_button);
        mUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userLoginNavigation();
            }
        });

        //TODO: Need to fix the distance between the dots in jake wharton pager
        mPager = (ViewPager) returnView.findViewById(R.id.pager);
        mUserAdapter.addView(LayoutInflater.from(mPager.getContext()).inflate(R.layout.user_page1, null));
        mUserAdapter.addView(LayoutInflater.from(mPager.getContext()).inflate(R.layout.user_pag2, null));
        mUserAdapter.addView(LayoutInflater.from(mPager.getContext()).inflate(R.layout.user_page3, null));
        mPager.setAdapter(mUserAdapter);
        final CirclePageIndicator paginator = (CirclePageIndicator) returnView.findViewById(R.id.titles);

        paginator.setViewPager(mPager);

        return returnView;
    }

    @Override
    public void onResume() {

        callchecker(mPager, mUserAdapter);

        super.onResume();
    }

    /**
     * @param viewPager    Determine what is the current condition of viewpgager
     * @param pagerAdapter adapter to contain the views and return id neccessary
     */
    private void callchecker(final ViewPager viewPager, final PagerAdapter pagerAdapter) {

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
            }

            @Override
            public void onPageSelected(int i) {
                onPageChanged(i, pagerAdapter.getCount());
            }

            @Override
            public void onPageScrollStateChanged(int i) {
            }
        });

    }


    // Following is the method to animate buttons when the pager
    //does stuff to move the screens left to right or vice versa

    private void onPageChanged(int pos, int count) {

        if (pos + 1 == count) {
            mUserButton.setVisibility(View.VISIBLE);          // this is last page. show the button
        }
        else {
            mUserButton.setVisibility(View.GONE);

        }
    }


    private void userLoginNavigation() {

        /** fire the login intent from here and take the user to the login */
        startActivity(new Intent(getActivity(), Dogather_Login_Activity.class));

    }

}
