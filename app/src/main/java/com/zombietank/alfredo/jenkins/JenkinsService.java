package com.zombietank.alfredo.jenkins;

import com.zombietank.alfredo.jenkins.domain.Job;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface JenkinsService {
    @GET("/job/{jobName}/api/json")
    Observable<Job> loadJob(@Path("jobName") String jobName);
}
