package com.zombietank.alfredo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.zombietank.alfredo.jenkins.JenkinsService;
import com.zombietank.alfredo.jenkins.JobListFragment;
import com.zombietank.alfredo.jenkins.domain.job.Job;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements JobListFragment.OnListFragmentInteractionListener {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @Inject
    JenkinsService jenkinsService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ((AlfredoApplication) getApplication()).getJenkinsComponent().inject(this);
        setSupportActionBar(toolbar);

        if (savedInstanceState == null) {
            Fragment jobListFragment = JobListFragment.newInstance(1);
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.content, jobListFragment).commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public void onListFragmentInteraction(Job job) {
        Log.i(MainActivity.class.getSimpleName(), "Clicked on: " + job);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
