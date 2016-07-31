package com.zombietank.alfredo;

import android.app.Application;

public class AlfredoApplication extends Application {

    private JenkinsComponent jenkinsComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        this.jenkinsComponent = DaggerJenkinsComponent.builder().build();
    }

    public JenkinsComponent getJenkinsComponent() {
        return jenkinsComponent;
    }
}
