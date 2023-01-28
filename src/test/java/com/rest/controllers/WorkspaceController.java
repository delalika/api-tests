package com.rest.controllers;

import com.rest.helpers.HttpClientHelper;
import okhttp3.HttpUrl;

public class WorkspaceController {
    protected HttpUrl httpUrl = new HttpClientHelper().createUrl();
    protected HttpClientHelper httpClientHelper = new HttpClientHelper();

    public String getWorkspace(String id){
        HttpUrl url = httpUrl.newBuilder()
                .addPathSegment("workspaces")
                .addPathSegment(id)
                .build();
        return httpClientHelper.get(url);
    }
    public String createWorkspace(String body){
        HttpUrl url = httpUrl.newBuilder()
                .addPathSegment("workspaces")
                .build();
        return httpClientHelper.post(url, body);
    }

    public String updateWorkspace(String body, String id){
        HttpUrl url = httpUrl.newBuilder()
                .addPathSegment("workspaces")
                .addPathSegment(id)
                .build();
        return httpClientHelper.put(url, body);
    }

    public void deleteWorkspace(String id){
        HttpUrl url = httpUrl.newBuilder()
                .addPathSegment("workspaces")
                .addPathSegment(id)
                .build();
        httpClientHelper.delete(url);
    }
}
