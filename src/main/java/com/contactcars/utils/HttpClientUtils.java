package com.contactcars.utils;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ClassicHttpResponse;

import java.io.IOException;

public class HttpClientUtils {

    public static int getStatusCode(String targetUrl) throws IOException {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(targetUrl);
            ClassicHttpResponse response = httpClient.execute(request);
                return response.getCode();  // returns status code (e.g., 200, 404, etc.)
        }
    }
}

