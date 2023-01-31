package com.rest.helpers;

import com.rest.models.Auth;
import okhttp3.*;
import org.testng.Assert;

import java.io.IOException;

public class HttpClientHelper {
    private final OkHttpClient client = new OkHttpClient();
    private final Auth auth = new Auth();

    public String get(HttpUrl url, int expectedCode) {
        Request request = new Request.Builder()
                .header(auth.getName(), auth.getValue())
                .url(url)
                .get()
                .build();
        return executeCall(request, expectedCode);
    }
    public String post(HttpUrl url, String json, int expectedCode) {
        MediaType mediaType = MediaType.parse("application/json; charset=uft-8");
        RequestBody requestBody = RequestBody.create(json, mediaType);
        Request request = new Request.Builder().
                header(auth.getName(), auth.getValue()).
                url(url).
                post(requestBody).
                build();
        return executeCall(request, expectedCode);
    }

    public String put(HttpUrl url, String json, int expectedCode) {
        MediaType mediaType = MediaType.parse("application/json; charset=uft-8");
        RequestBody requestBody = RequestBody.create(json, mediaType);
        Request request = new Request.Builder()
                .header(auth.getName(), auth.getValue())
                .url(url)
                .put(requestBody)
                .build();
        return executeCall(request, expectedCode);
    }

    public void delete(HttpUrl url, int expectedCode){
        Request request = new Request.Builder()
                .header(auth.getName(), auth.getValue())
                .url(url)
                .delete()
                .build();
        executeCall(request, expectedCode);
    }
    public HttpUrl createUrl(){
        return new HttpUrl.Builder()
                .scheme("https")
                .host("api.postman.com")
                .build();
    }

    private String executeCall(Request request, int executedCode){
        try{
            Response response = client.newCall(request).execute();
            ResponseBody responseBody = response.body();
            Assert.assertEquals(response.code(), executedCode);
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
