package com.zombietank.alfredo;

import com.zombietank.alfredo.jenkins.JobListFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AlfredoModule.class})
public interface JenkinsComponent {
    void inject(MainActivity activity);

    void inject(JobListFragment jobListFragment);
}
