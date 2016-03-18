package com.kalpnil.ksinfotech.tsec.tsec;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.kalpnil.ksinfotech.tsec.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abc on 27-Jun-15.
 */
public class TabsPagerAdapter extends PagerAdapter {

    String tabs[] = {""};
    Activity activity;


    private RecyclerView mRecyclerView;
    private ProgressBar progressBar;
    private NoticesFeedParser mNewsFeeder;
    private List<RSSFeed> mRssFeedList = new ArrayList<RSSFeed>();

    public TabsPagerAdapter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return tabs.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return o == view;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = null;
        view = activity.getLayoutInflater().inflate(R.layout.pager_item, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(activity));
        performAsyncTask(position, mRecyclerView);
        ((ViewPager) container).addView(view);
        return view;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object view) {
        ((ViewPager) container).removeView((View) view);
    }
    public void performAsyncTask(int pos, RecyclerView mrecyclerView) {
        boolean isNetworkAvailable = ConnectionDetector.isConnectingToInternet(activity.getApplicationContext());
        if (isNetworkAvailable) {
            new DoRssFeedTask(mrecyclerView, progressBar).execute(Constants.TOPSTORIES[pos]);
        } else {
            Toast.makeText(activity, "No Internet Connection", Toast.LENGTH_SHORT).show();
        }
    }
    public class DoRssFeedTask extends AsyncTask<String, Void, List<RSSFeed>> {
        ProgressBar prog;
        String jsonStr = null;
        NoticesFeedParser mNewsFeeder;
        RecyclerView recyclerView;
        ProgressBar pbar;
        public DoRssFeedTask(RecyclerView recyclerView1, ProgressBar progBar) {
            super();
            this.recyclerView = recyclerView1;
            this.pbar = progBar;
        }
        @Override
        protected void onPreExecute() {

            pbar.setVisibility(View.VISIBLE);
            Log.i("Fragment ASyncTask", "onPreExecute()");
        }
        @Override
        protected List<RSSFeed> doInBackground(String... params) {

            for (String urlVal : params) {
                mNewsFeeder = new NoticesFeedParser(urlVal);
            }
            mRssFeedList = mNewsFeeder.parseXmlData();

            Log.i("Fragment ASyncTask", "doInBackground()");

            return mRssFeedList;
        }
        @Override
        protected void onPostExecute(List<RSSFeed> result) {
            pbar.setVisibility(View.GONE);
            settingAdapter(recyclerView);
            Log.i("Fragment ASyncTask", "onPostExecute()");
        }
    }
    public void settingAdapter(RecyclerView rv) {
        NoticesDataAdapter mAdapter = new NoticesDataAdapter(activity, mRssFeedList);
        int count = mRssFeedList.size();
        if (count != 0 && mAdapter != null) {
            rv.setAdapter(mAdapter);
        }
    }
}
