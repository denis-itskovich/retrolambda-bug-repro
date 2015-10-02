// Copyright 2015 Denis Itskovich
// Refer to LICENSE.txt for license details
package com.test.client;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential;
import com.test.backend.myApi.MyApi;
import com.test.backend.myApi.model.MyBean;

import java.io.IOException;

/**
 * Created by Denis on 02/10/2015
 * <File Description>
 */
public class Client {
    private final GoogleAccountCredential credential;

    public Client(GoogleAccountCredential credential) {
        this.credential = credential;
    }

    public MyBean hello() throws IOException {
        return new MyApi.Builder(AndroidHttp.newCompatibleTransport(), AndroidJsonFactory.getDefaultInstance(), credential)
                .setRootUrl("http://127.0.0.1:8080/")
                .build()
                .sayHi("Denis")
                .execute();
    }
}
