package com.rest.controllers;

import com.rest.helpers.HttpClientHelper;
import okhttp3.HttpUrl;

public class WorkspaceController {
    protected HttpUrl httpUrl = new HttpClientHelper().createUrl();
    protected HttpClientHelper httpClientHelper = new HttpClientHelper();

    public String getWorkspace(String id, int expectedCode){
        HttpUrl url = httpUrl.newBuilder()
                .addPathSegment("workspaces")
                .addPathSegment(id)
                .build();
        return httpClientHelper.get(url, expectedCode);
    }
    public String createWorkspace(String body, int expectedCode){
        HttpUrl url = httpUrl.newBuilder()
                .addPathSegment("workspaces")
                .build();
        return httpClientHelper.post(url, body, expectedCode);
    }

    public String updateWorkspace(String body, String id, int expectedCode){
        HttpUrl url = httpUrl.newBuilder()
                .addPathSegment("workspaces")
                .addPathSegment(id)
                .build();
        return httpClientHelper.put(url, body, expectedCode);
    }

    public void deleteWorkspace(String id, int expectedCode){
        HttpUrl url = httpUrl.newBuilder()
                .addPathSegment("workspaces")
                .addPathSegment(id)
                .build();
        httpClientHelper.delete(url, expectedCode);
    }
}
