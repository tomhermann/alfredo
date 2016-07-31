package com.zombietank.alfredo.jenkins;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zombietank.alfredo.AlfredoApplication;
import com.zombietank.alfredo.MainActivity;
import com.zombietank.alfredo.R;
import com.zombietank.alfredo.jenkins.domain.job.Job;
import com.zombietank.alfredo.jenkins.domain.server.Server;

import javax.inject.Inject;

import butterknife.ButterKnife;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class JobListFragment extends Fragment {
    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;
    private JobListRecyclerViewAdapter adapter;
    @Inject
    JenkinsService jenkinsService;

    public JobListFragment() {

    }

    public static JobListFragment newInstance(int columnCount) {
        JobListFragment fragment = new JobListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) inflater.inflate(R.layout.fragment_joblist, container, false);
        swipeRefreshLayout.setOnRefreshListener(this::loadJobs);
        RecyclerView list = ButterKnife.findById(swipeRefreshLayout, R.id.list);
        this.adapter = new JobListRecyclerViewAdapter(mListener);
        Context context = list.getContext();
        if (mColumnCount <= 1) {
            list.setLayoutManager(new LinearLayoutManager(context));
        } else {
            list.setLayoutManager(new GridLayoutManager(context, mColumnCount));
        }
        list.setAdapter(adapter);
        return swipeRefreshLayout;
    }

    public Subscription loadJobs() {
        return jenkinsService
                .loadServerDetails()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(Server::getJobs)
                .subscribe(jobs -> {
                    adapter.setJobs(jobs);
                    boolean allBuildsPassing = Observable.from(jobs).all(Job::isPassing).toBlocking().first();
                    ((MainActivity) getActivity()).setToolbarColor(allBuildsPassing ? R.color.passing : R.color.failing);

                    SwipeRefreshLayout swipeRefreshLayout = ButterKnife.findById(getActivity(), R.id.swipeRefreshLayout);
                    swipeRefreshLayout.setRefreshing(false);
                });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        ((AlfredoApplication) getActivity().getApplication()).getJenkinsComponent().inject(this);
        ButterKnife.bind(this, getActivity());

        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
            this.adapter = new JobListRecyclerViewAdapter(mListener);
            loadJobs();
        } else {
            throw new RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener");
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     */
    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(Job job);
    }
}
