package com.rest.helpers;

import com.rest.models.Auth;
import okhttp3.*;

import java.io.IOException;

public class HttpClientHelper {
    private final OkHttpClient client = new OkHttpClient();
    private final Auth auth = new Auth();

    public String get(HttpUrl url) {
        Request request = new Request.Builder()
                .header(auth.getName(), auth.getValue())
                .url(url)
                .get()
                .build();
        return executeCall(request);
    }
    public String post(HttpUrl url, String json) {
        MediaType mediaType = MediaType.parse("application/json; charset=uft-8");
        RequestBody requestBody = RequestBody.create(json, mediaType);
        Request request = new Request.Builder().
                header(auth.getName(), auth.getValue()).
                url(url).
                post(requestBody).
                build();
        return executeCall(request);
    }

    public String put(HttpUrl url, String json) {
        MediaType mediaType = MediaType.parse("application/json; charset=uft-8");
        RequestBody requestBody = RequestBody.create(json, mediaType);
        Request request = new Request.Builder()
                .header(auth.getName(), auth.getValue())
                .url(url)
                .put(requestBody)
                .build();
        return executeCall(request);
    }

    public void delete(HttpUrl url){
        Request request = new Request.Builder()
                .header(auth.getName(), auth.getValue())
                .url(url)
                .delete()
                .build();
        executeCall(request);
    }
    public HttpUrl createUrl(){
        return new HttpUrl.Builder()
                .scheme("https")
                .host("api.postman.com")
                .build();
    }

    private String executeCall(Request request){
        try{
            ResponseBody responseBody = client.newCall(request).execute().body();
            if (responseBody == null){
                return "";
            } else {
                return responseBody.string();
            }
        } catch (IOException e){
            throw  new RuntimeException(e.getMessage());
        }
    }
}
