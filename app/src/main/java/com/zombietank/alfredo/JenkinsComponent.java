package com.zombietank.alfredo;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AlfredoModule.class})
public interface JenkinsComponent {
    void inject(MainActivity activity);

}
