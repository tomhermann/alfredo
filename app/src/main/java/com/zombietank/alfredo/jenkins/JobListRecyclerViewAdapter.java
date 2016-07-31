package com.zombietank.alfredo.jenkins;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zombietank.alfredo.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class JobListRecyclerViewAdapter extends RecyclerView.Adapter<JobListRecyclerViewAdapter.ViewHolder> {
    private final List<Job> values;
    private final JobListFragment.OnListFragmentInteractionListener mListener;

    public JobListRecyclerViewAdapter(List<Job> items, JobListFragment.OnListFragmentInteractionListener listener) {
        values = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.job_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.job = values.get(position);
        holder.firstLine.setText(holder.job.getName());
        holder.secondLine.setText(holder.job.getStatus());
        holder.view.setOnClickListener(v -> {
            if (null != mListener) {
                mListener.onListFragmentInteraction(holder.job);
            }
        });
    }

    @Override
    public int getItemCount() {
        return values.size();
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
