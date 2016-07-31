package com.zombietank.alfredo.jenkins;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zombietank.alfredo.R;
import com.zombietank.alfredo.jenkins.domain.job.Job;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class JobListRecyclerViewAdapter extends RecyclerView.Adapter<JobListRecyclerViewAdapter.ViewHolder> {
    private final JobListFragment.OnListFragmentInteractionListener mListener;
    private List<Job> jobs = new ArrayList<>();

    public JobListRecyclerViewAdapter(JobListFragment.OnListFragmentInteractionListener listener) {
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.job_row, parent, false);
        return new ViewHolder(view);
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Job job = jobs.get(position);
        holder.job = job;
        holder.firstLine.setText(job.getName());
        holder.secondLine.setText(job.getDescription());
        holder.icon.setImageResource(job.isPassing() ? R.drawable.blue_circle : R.drawable.red_circle);
        holder.view.setOnClickListener(v -> {
            if (null != mListener) {
                mListener.onListFragmentInteraction(holder.job);
            }
        });
    }

    @Override
    public int getItemCount() {
        return jobs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final View view;
        @BindView(R.id.icon)
        ImageView icon;
        @BindView(R.id.jobName)
        TextView firstLine;
        @BindView(R.id.description)
        TextView secondLine;

        public Job job;

        public ViewHolder(View view) {
            super(view);
            this.view = view;
            ButterKnife.bind(this, view);
        }
    }
}
