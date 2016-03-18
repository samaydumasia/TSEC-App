package com.kalpnil.ksinfotech.tsec.tsec;


import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.kalpnil.ksinfotech.tsec.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NoticesFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private NoticesFeedParser mNewsFeeder;
    private List<RSSFeed> mRssFeedList = new ArrayList<RSSFeed>();
    public static NoticesFragment newInstance(CharSequence title,int position) {
        Bundle bundle = new Bundle();
        bundle.putCharSequence("title", title);
        bundle.putInt("position", position);
        NoticesFragment fragment = new NoticesFragment();
        fragment.setArguments(bundle);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        Log.i("Fragment", "OncreateView()");
        return rootView;
    }
    @Override
    public void onStart() {
        super.onStart();
        Log.i("Fragment", "onStart()");
        mRecyclerView = (RecyclerView) getActivity().findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        performAsyncTask();
    }
    public void performAsyncTask() {
        if (mRssFeedList.size() > 0) {
            settingAdapter();
        } else {
            boolean isNetworkAvailable = ConnectionDetector.isConnectingToInternet(getActivity().getApplicationContext());
            if (isNetworkAvailable) {
                Bundle args = getArguments();
                if (args != null)
                {
                    new DoRssFeedTask().execute(Constants.TOPSTORIES[args.getInt("position")]);
                }
                else
                {
                    Toast.makeText(getActivity(), "Oops!!! News Fragment", Toast.LENGTH_LONG).show();
                }
            }
            else {
                Toast.makeText(getActivity(), "No Internet Connection", Toast.LENGTH_LONG).show();
            }
        }
    }
    public class DoRssFeedTask extends AsyncTask<String, Void, List<RSSFeed>> {
        ProgressDialog prog;
        String jsonStr = null;
        @Override
        protected void onPreExecute() {
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
            settingAdapter();
            Log.i("Fragment ASyncTask", "onPostExecute()");
        }
    }
    public void settingAdapter() {
        mAdapter = new NoticesDataAdapter(getActivity(), mRssFeedList);
        int count = mRssFeedList.size();
        if (count != 0 && mAdapter != null) {
            mRecyclerView.setAdapter(mAdapter);
        }
    }
}
